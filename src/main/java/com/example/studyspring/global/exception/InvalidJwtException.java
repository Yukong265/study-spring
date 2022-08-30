package com.example.studyspring.global.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.PostsException;

public class InvalidJwtException extends PostsException {
    public static final InvalidJwtException EXCEPTION =
            new InvalidJwtException();

    public InvalidJwtException(){
        super(ErrorCode.INVALID_JWT);
    }
}
