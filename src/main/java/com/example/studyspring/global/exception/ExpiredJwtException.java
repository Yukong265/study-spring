package com.example.studyspring.global.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.ProjectException;

public class ExpiredJwtException extends ProjectException {
    public static final ExpiredJwtException EXCEPTION =
            new ExpiredJwtException();

    public ExpiredJwtException(){
        super(ErrorCode.EXPIRED_JWT);
    }
}
