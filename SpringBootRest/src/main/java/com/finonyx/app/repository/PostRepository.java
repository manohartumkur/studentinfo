package com.finonyx.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finonyx.app.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
