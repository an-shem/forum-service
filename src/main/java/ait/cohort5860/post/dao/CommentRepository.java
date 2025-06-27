package ait.cohort5860.post.dao;

import ait.cohort5860.post.modal.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
