package ait.cohort5860.post.dao;

import ait.cohort5860.post.dto.PostDto;
import ait.cohort5860.post.modal.Post;
import ait.cohort5860.post.modal.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByAuthor(String author);

    List<Post> findPostsByTagsIn(List<String> tags);

    List<PostDto> findPostsByDateCreatedBetween(LocalDate dateFrom, LocalDate dateTo);
}
