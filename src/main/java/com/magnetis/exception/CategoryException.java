package com.magnetis.exception;

public class CategoryException extends RuntimeException{
    String desc;

    public CategoryException(String desc) {
        this.desc = desc;
    }
}
