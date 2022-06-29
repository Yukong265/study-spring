package com.example.studyspring.web;

import com.example.studyspring.service.PostsService;
import com.example.studyspring.web.dto.request.PostsSaveRequestDto;
import com.example.studyspring.web.dto.request.PostsUpdateRequestDto;
import com.example.studyspring.web.dto.response.PostsResponseDto;
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
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
