package com.example.studyspring.domain.posts.web.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequest {
    private String title;
    private String content;
}
