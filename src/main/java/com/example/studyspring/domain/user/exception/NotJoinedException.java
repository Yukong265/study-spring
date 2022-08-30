package com.example.studyspring.domain.user.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.PostsException;

public class NotJoinedException extends PostsException {
    public static final NotJoinedException EXCEPTION = new NotJoinedException();

    public NotJoinedException(){
        super(ErrorCode.USER_NOTFOUND);
    }
}
