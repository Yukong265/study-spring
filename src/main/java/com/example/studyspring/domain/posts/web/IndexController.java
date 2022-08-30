package com.example.studyspring.domain.posts.web;

import com.example.studyspring.domain.posts.service.PostsService;
import com.example.studyspring.domain.posts.web.dto.response.PostsListResponse;
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
    public PostsListResponse findAllDesc(){
        return postsService.findAllDesc();
    }

}
