package ait.cohort5860.post.service;

import ait.cohort5860.post.dto.NewCommentDto;
import ait.cohort5860.post.dto.NewPostDto;
import ait.cohort5860.post.dto.PostDto;

import java.time.LocalDate;
import java.util.List;

public interface PostService {

    PostDto addNewPost(String author, NewPostDto newPostDto);

    PostDto findPostById(Long id);

    void addLike(Long id);

    PostDto updatePost(Long id, NewPostDto newPostDto);

    PostDto deletePost(Long id);

    PostDto addComment(Long id, String author, NewCommentDto newCommentDto);

    Iterable<PostDto> findPostsByAuthor(String author);

    Iterable<PostDto> findPostsByTags(List<String> tags);

    Iterable<PostDto> findPostsByPeriod(LocalDate dateFrom, LocalDate dateTo);


//    PostDto addPost(NewPostDto newPostDto);
//
//    PostDto findPostById(long id);
//
//    void addLike();
//
//    List<PostDto> findPostsByAuthor();
//
//    PostDto addComment(CommentDto commentDto);
//
//    PostDto removePost();
//
//    List<PostDto> findPostsByTags(String tags);
//
//    List<PostDto> findPostsByPeriod(String dateFrom, String dateTo);
//
//    PostDto updatePost(PostDto postDto);
}