package ait.cohort5860.post.service;

import ait.cohort5860.post.dao.CommentRepository;
import ait.cohort5860.post.dao.PostRepository;
import ait.cohort5860.post.dao.TagRepository;
import ait.cohort5860.post.dto.NewCommentDto;
import ait.cohort5860.post.dto.NewPostDto;
import ait.cohort5860.post.dto.PostDto;
import ait.cohort5860.post.dto.exceptions.PostNotFoundException;
import ait.cohort5860.post.modal.Comment;
import ait.cohort5860.post.modal.Post;
import ait.cohort5860.post.modal.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public PostDto addNewPost(String author, NewPostDto newPostDto) {
        Post post = new Post(newPostDto.getTitle(), newPostDto.getContent(), author);
        Set<String> tags = newPostDto.getTags();
        //Handle tags
        if (tags != null) {
            for (String tagName : tags) {
                Tag tag = tagRepository.findById(tagName).orElseGet(() -> tagRepository.save(new Tag(tagName)));
                post.addTag(tag);
            }
        }
        post = postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto findPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public void addLike(Long id) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
        post.addLikes();
        postRepository.save(post);
    }

    @Override
    public PostDto updatePost(Long id, NewPostDto newPostDto) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
        if (newPostDto.getTitle() != null) {
            post.setTitle(newPostDto.getTitle());
        }
        if (newPostDto.getContent() != null) {
            post.setContent(newPostDto.getContent());
        }
        Set<String> tags = newPostDto.getTags();
        if (tags != null) {
            for (String tagName : tags) {
                Tag tag = tagRepository.findById(tagName).orElseGet(() -> tagRepository.save(new Tag(tagName)));
                post.addTag(tag);
            }
        }
        postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
        PostDto postDto = modelMapper.map(post, PostDto.class);
        postRepository.delete(post);
        return postDto;
    }

    @Override
    public PostDto addComment(Long id, String author, NewCommentDto newCommentDto) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
        Comment comment = new Comment(author, newCommentDto.getMessage(), post);
        commentRepository.save(comment);
        post.addComment(comment);
        postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public Iterable<PostDto> findPostsByAuthor(String author) {
        List<Post> posts = postRepository.findPostsByAuthor(author);
        return posts.stream().map(p -> modelMapper.map(p, PostDto.class)).collect(Collectors.toList());

    }

    @Override
    public Iterable<PostDto> findPostsByTags(List<String> tags) {
        System.out.println("Start");
        Set<Tag> tagsSet = tags.stream()
                .map(Tag::new)
                .collect(Collectors.toSet());
        System.out.println("Set<Tag> >> " + tagsSet);
        List<Post> postsByTags = postRepository.findPostsByTagsIn(tags);
//                .stream()
//                .map(p -> {
//                    System.out.println("post " + p);
//                    return modelMapper.map(p, PostDto.class);
//                })
//                .collect(Collectors.toList());
        System.out.println("postsByTags >> " + postsByTags);
        return null;
    }

    @Override
    public Iterable<PostDto> findPostsByPeriod(LocalDate dateFrom, LocalDate dateTo) {
        return postRepository.findPostsByDateCreatedBetween(dateFrom, dateTo);
    }
}
