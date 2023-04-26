package com.inditex.pricecalculator.config;

import com.inditex.pricecalculator.dto.PriceQueryResponseDto;
import com.inditex.pricecalculator.exception.NoPricesFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = NoPricesFoundException.class)
    public ResponseEntity<PriceQueryResponseDto> blogNotFoundException(NoPricesFoundException noPricesFoundException) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
