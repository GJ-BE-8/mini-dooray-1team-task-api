package com.nhnacademy.testtest.exception;

public class CommentNotFoundException extends RuntimeException {

    public CommentNotFoundException(String message) {
        super(message);
    }
}
