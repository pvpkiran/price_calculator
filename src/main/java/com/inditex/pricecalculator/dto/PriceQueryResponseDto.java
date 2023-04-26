package com.inditex.pricecalculator.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PriceQueryResponseDto {
    private final long productId;
    private final String brandName;
    private final double price;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final int rate;
}
