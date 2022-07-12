package com.example.studyspring.domain.posts.service;


import com.example.studyspring.domain.posts.domain.Posts;
import com.example.studyspring.domain.posts.exception.PostsNotFoundException;
import com.example.studyspring.domain.posts.domain.repository.PostsRepository;
import com.example.studyspring.domain.posts.domain.web.dto.request.PostsSaveRequest;
import com.example.studyspring.domain.posts.domain.web.dto.request.PostsUpdateRequest;
import com.example.studyspring.domain.posts.domain.web.dto.response.PostsListResponse;
import com.example.studyspring.domain.posts.domain.web.dto.response.PostsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public void save(PostsSaveRequest requestDto) {
        postsRepository.save(
                Posts.builder()
                        .title(requestDto.getTitle())
                        .content(requestDto.getContent())
                        .author(requestDto.getAuthor())
                        .build()
        );
    }

    @Transactional
    public void update(Long id, PostsUpdateRequest requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> PostsNotFoundException.EXCEPTION);
        posts.update(requestDto.getTitle(), requestDto.getContent());
    }

    public PostsResponse findById(Long id) {
        Posts entity = postsRepository.findPostsById(id)
                .orElseThrow(() -> PostsNotFoundException.EXCEPTION);

        return PostsResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .build();
    }

    @Transactional(readOnly = true)
    public PostsListResponse findAllDesc() {
        List<PostsResponse> postList = postsRepository.findAll().stream()
                .map(posts -> new PostsResponse(
                        posts.getId(),
                        posts.getTitle(),
                        posts.getContent(),
                        posts.getAuthor()
                )).collect(Collectors.toList());

        return new PostsListResponse(postList);
    }

    @Transactional
    public void deleteById(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> PostsNotFoundException.EXCEPTION);

        postsRepository.delete(posts);
    }
}
