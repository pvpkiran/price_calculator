package com.inditex.pricecalculator.service;

import com.inditex.pricecalculator.dto.PriceQueryRequestDto;
import com.inditex.pricecalculator.dto.PriceQueryResponseDto;
import com.inditex.pricecalculator.model.Prices;
import com.inditex.pricecalculator.repository.PricesRepository;

import java.util.Comparator;
import java.util.List;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
public class PriceQueryService {

    private final PricesRepository pricesRepository;

    public PriceQueryService(final PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    public PriceQueryResponseDto getApplicablePrice(final PriceQueryRequestDto priceQueryRequestDto) {
        final List<Prices> prices =
            pricesRepository.findByBrand_BrandNameAndProduct_ProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(priceQueryRequestDto.getBrandName(),
                priceQueryRequestDto.getProductId(),
                priceQueryRequestDto.getDate(),
                priceQueryRequestDto.getDate()
            );

        if (prices.size() > 1) {
            prices.sort(Comparator.comparingInt(Prices::getPriority).reversed());
            log.info("Found multiple prices for given date {}", priceQueryRequestDto.getDate());
        }

        final Prices price = prices.get(0);
        return buildPriceQueryResponse(priceQueryRequestDto, price, PriceQueryResponseDto.builder());
    }

    private PriceQueryResponseDto buildPriceQueryResponse(final PriceQueryRequestDto priceQueryRequestDto,
                                                          final Prices price,
                                                          final PriceQueryResponseDto.PriceQueryResponseDtoBuilder builder) {
        builder.price(price.getPrice())
            .rate(price.getPriceList())
            .startDate(price.getStartDate())
            .endDate(price.getEndDate())
            .productId(priceQueryRequestDto.getProductId())
            .brandName(priceQueryRequestDto.getBrandName());

        return builder.build();
    }
}
