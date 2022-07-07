package com.example.studyspring.domain.posts.domain.web;

import com.example.studyspring.domain.posts.domain.service.PostsService;
import com.example.studyspring.domain.posts.domain.web.dto.response.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/s")
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/main")
    public PostsListResponseDto findAllDesc(){
        return postsService.findAllDesc();
    }

}
