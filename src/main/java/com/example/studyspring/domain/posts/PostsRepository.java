package com.example.studyspring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PostsRepository extends JpaRepository<Posts, Long> {

    List<Posts> findAll();
    Optional<Posts> findPostsById(Long id);
}

