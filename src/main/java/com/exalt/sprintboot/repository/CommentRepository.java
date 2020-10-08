package com.exalt.sprintboot.repository;

import com.exalt.sprintboot.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
