package com.example.studyspring.domain.posts.web.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PostsSaveRequest {
    private String title;
    private String content;
    private String author;
}
