package com.inditex.pricecalculator.exception;

public class NoPricesFoundException extends RuntimeException {
    public NoPricesFoundException(String message) {
        super(message);
    }
}
