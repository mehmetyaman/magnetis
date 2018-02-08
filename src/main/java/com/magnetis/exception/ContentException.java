package com.magnetis.exception;

public class ContentException extends RuntimeException{
    String desc;

    public ContentException(String desc) {
        this.desc = desc;
    }
}
