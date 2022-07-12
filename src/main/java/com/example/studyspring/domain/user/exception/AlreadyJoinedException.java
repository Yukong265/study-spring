package com.example.studyspring.domain.user.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.PostsException;

public class AlreadyJoinedException extends PostsException {

    public static final PostsException EXCEPTION =
            new AlreadyJoinedException();

    private AlreadyJoinedException() {
        super(ErrorCode.ALREADY_JOINED);
    }
}
