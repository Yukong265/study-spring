package com.example.studyspring.web;

import com.example.studyspring.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class IndexController {

    private final PostsService postsService;

    @GetMapping
    public String index(){
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
