package com.inditex.pricecalculator.controller;

import com.inditex.pricecalculator.dto.PriceQueryRequestDto;
import com.inditex.pricecalculator.dto.PriceQueryResponseDto;
import com.inditex.pricecalculator.service.PriceQueryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceQueryService priceQueryService;

    public PriceController(final PriceQueryService priceQueryService) {
        this.priceQueryService = priceQueryService;
    }

    @PostMapping("/query")
    public PriceQueryResponseDto getApplicableRate(@RequestBody final PriceQueryRequestDto priceQueryRequestDto) {
        return priceQueryService.getApplicablePrice(priceQueryRequestDto);
    }
}
