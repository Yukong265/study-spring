package com.example.studyspring.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostsListResponseDto {
    List<PostsResponseDto> postList;
}