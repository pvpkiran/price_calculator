package com.inditex.pricecalculator.repository;

import com.inditex.pricecalculator.model.Prices;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PricesRepository extends CrudRepository<Prices, Long> {
   List<Prices> findByBrand_BrandNameAndProduct_ProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(String brand_brandName, long product_productId, LocalDateTime startDate, LocalDateTime endDate);
}
