package com.example.studyspring.domain.posts.web;

import com.example.studyspring.domain.posts.service.PostsService;
import com.example.studyspring.domain.posts.web.dto.request.PostsSaveRequest;
import com.example.studyspring.domain.posts.web.dto.request.PostsUpdateRequest;
import com.example.studyspring.domain.posts.web.dto.response.PostsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/posts")
    public void save(@RequestBody PostsSaveRequest requestDto){
        postsService.save(requestDto);
    }

    @PutMapping("/posts/{id}")
    public void update(@PathVariable Long id, @RequestBody PostsUpdateRequest requestDto){
        postsService.update(id, requestDto);
    }

    @GetMapping("/posts/{id}")
    public PostsResponse findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/posts/{id}")
    public void deleteById(@PathVariable Long id) { postsService.deleteById(id); }
}
