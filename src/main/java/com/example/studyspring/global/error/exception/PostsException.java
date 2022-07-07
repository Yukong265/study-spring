package com.example.studyspring.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostsException extends RuntimeException{
    private final ErrorCode errorCode;
}
