package com.inditex.pricecalculator.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PriceQueryRequestDto {
    private final String brandName;
    private final long productId;
    private final LocalDateTime date;
}
