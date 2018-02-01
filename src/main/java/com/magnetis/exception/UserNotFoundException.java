package com.magnetis.exception;

public class UserNotFoundException extends UserException {
    public UserNotFoundException(String desc) {
        super(desc);
    }
}
