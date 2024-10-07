package com.socialmedia.Social_Media_App.repository;

import com.socialmedia.Social_Media_App.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
