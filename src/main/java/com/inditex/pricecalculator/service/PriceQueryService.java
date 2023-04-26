package com.inditex.pricecalculator.service;

import com.inditex.pricecalculator.dto.PriceQueryRequestDto;
import com.inditex.pricecalculator.dto.PriceQueryResponseDto;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
public class PriceQueryService {

    public PriceQueryResponseDto getApplicablePrice(final PriceQueryRequestDto priceQueryRequestDto) {
     return null;
    }
}
