package com.example.studyspring.domain.posts.domain.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateResponseDto {
    private String title, content;

    @Builder
    public PostsUpdateResponseDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
