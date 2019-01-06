package com.sbs.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbs.springit.domain.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Long>{

}
