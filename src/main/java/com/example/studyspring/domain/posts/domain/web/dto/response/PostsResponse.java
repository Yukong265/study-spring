package com.example.studyspring.domain.posts.domain.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PostsResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
}
