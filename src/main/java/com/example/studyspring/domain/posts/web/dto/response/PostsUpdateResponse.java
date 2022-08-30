package com.example.studyspring.domain.posts.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateResponse {
    private String title, content;

    @Builder
    public PostsUpdateResponse(String title, String content){
        this.title = title;
        this.content = content;
    }
}
