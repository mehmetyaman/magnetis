package com.magnetis.exception;

public class UserException extends RuntimeException {
    String desc;

    public UserException(String desc) {
        this.desc = desc;
    }
}
