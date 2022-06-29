package com.example.studyspring.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
}
