package com.magnetis.exception;

public class ProductNotFoundException extends ProductException {
    public ProductNotFoundException(String desc) {
        super(desc);
    }
}
