package com.example.studyspring.domain.posts.domain.web;

import com.example.studyspring.domain.posts.service.PostsService;
import com.example.studyspring.domain.posts.domain.web.dto.request.PostsSaveRequest;
import com.example.studyspring.domain.posts.domain.web.dto.request.PostsUpdateRequest;
import com.example.studyspring.domain.posts.domain.web.dto.response.PostsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public void save(@RequestBody PostsSaveRequest requestDto){
        postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public void update(@PathVariable Long id, @RequestBody PostsUpdateRequest requestDto){
        postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponse findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable Long id) { postsService.deleteById(id); }
}
