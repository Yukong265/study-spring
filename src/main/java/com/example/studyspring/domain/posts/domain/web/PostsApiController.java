package com.example.studyspring.domain.posts.domain.web;

import com.example.studyspring.domain.posts.domain.service.PostsService;
import com.example.studyspring.domain.posts.domain.web.dto.request.PostsSaveRequestDto;
import com.example.studyspring.domain.posts.domain.web.dto.request.PostsUpdateRequestDto;
import com.example.studyspring.domain.posts.domain.web.dto.response.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public void save(@RequestBody PostsSaveRequestDto requestDto){
        postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public void update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable Long id) { postsService.deleteById(id); }
}
