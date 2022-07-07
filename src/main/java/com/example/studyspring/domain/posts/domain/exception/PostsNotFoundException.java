package com.example.studyspring.domain.posts.domain.exception;

import com.example.studyspring.global.error.exception.ErrorCode;
import com.example.studyspring.global.error.exception.PostsException;

public class PostsNotFoundException extends PostsException {
    public static final PostsException EXCEPTION = new PostsNotFoundException();

    private PostsNotFoundException() {
        super(ErrorCode.POST_NOTFOUND);
    }
}
