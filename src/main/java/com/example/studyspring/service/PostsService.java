package com.example.studyspring.service;


import com.example.studyspring.domain.posts.Posts;
import com.example.studyspring.domain.posts.PostsRepository;
import com.example.studyspring.web.dto.request.PostsSaveRequestDto;
import com.example.studyspring.web.dto.request.PostsUpdateRequestDto;
import com.example.studyspring.web.dto.response.PostsListResponseDto;
import com.example.studyspring.web.dto.response.PostsResponseDto;
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
    public void save(PostsSaveRequestDto requestDto) {
        postsRepository.save(
                Posts.builder()
                        .title(requestDto.getTitle())
                        .content(requestDto.getContent())
                        .author(requestDto.getAuthor())
                        .build()
        );
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findPostsById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return PostsResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .build();
    }

    @Transactional(readOnly = true)
    public PostsListResponseDto findAllDesc() {
        List<PostsResponseDto> postList = postsRepository.findAll().stream()
                .map(posts -> new PostsResponseDto(
                        posts.getId(),
                        posts.getTitle(),
                        posts.getContent(),
                        posts.getAuthor()
                )).collect(Collectors.toList());

        return new PostsListResponseDto(postList);
    }
}
