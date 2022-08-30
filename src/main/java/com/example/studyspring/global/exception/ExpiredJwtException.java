package com.example.studyspring.global.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.PostsException;

public class ExpiredJwtException extends PostsException {
    public static final ExpiredJwtException EXCEPTION =
            new ExpiredJwtException();

    public ExpiredJwtException(){
        super(ErrorCode.EXPIRED_JWT);
    }
}
