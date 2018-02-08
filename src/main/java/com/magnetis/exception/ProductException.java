package com.magnetis.exception;

public class ProductException extends RuntimeException{

    String desc;

    public ProductException(String desc) {
        this.desc = desc;
    }
}
