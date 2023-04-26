package com.inditex.pricecalculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.pricecalculator.dto.PriceQueryRequestDto;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceCalculatorApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testPriceQueryForSinglePriceScenarioBeforeSale() throws Exception {
        final PriceQueryRequestDto priceQueryRequestDto = getPriceQueryRequestDto(14, 10);

        mockMvc.perform(post("/price/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(priceQueryRequestDto)))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                {
                  "productId": 35455,
                  "brandName": "ZARA",
                  "price": 35.5,
                  "startDate": "2020-06-14T00:00:00",
                  "endDate": "2020-12-31T23:59:59",
                  "rate": 1
                }"""));
    }

    @Test
    public void testPriceQueryForMultiplePriceScenarioDuringSale() throws Exception {
        final PriceQueryRequestDto priceQueryRequestDto = getPriceQueryRequestDto(14, 16);

        mockMvc.perform(post("/price/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(priceQueryRequestDto)))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                {
                  "productId": 35455,
                  "brandName": "ZARA",
                  "price": 25.45,
                  "startDate": "2020-06-14T15:00:00",
                  "endDate": "2020-06-14T18:30:00",
                  "rate": 2
                }"""));
    }

    @Test
    public void testPriceQueryForMultiplePriceScenarioAfterSale() throws Exception {
        final PriceQueryRequestDto priceQueryRequestDto = getPriceQueryRequestDto(14, 21);

        mockMvc.perform(post("/price/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(priceQueryRequestDto)))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                {
                  "productId": 35455,
                  "brandName": "ZARA",
                  "price": 35.5,
                  "startDate": "2020-06-14T00:00:00",
                  "endDate": "2020-12-31T23:59:59",
                  "rate": 1
                }"""));
    }

    @Test
    public void testPriceQueryForMultiplePriceScenarioWithDifferentPriceList() throws Exception {
        final PriceQueryRequestDto priceQueryRequestDto = getPriceQueryRequestDto(15, 10);

        mockMvc.perform(post("/price/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(priceQueryRequestDto)))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                {
                  "productId": 35455,
                  "brandName": "ZARA",
                  "price": 30.5,
                  "startDate": "2020-06-15T00:00:00",
                  "endDate": "2020-06-15T11:00:00",
                  "rate": 3
                }"""));
    }

    @Test
    public void testPriceQueryForSinglePriceScenarioWithDifferentPriceList() throws Exception {
        final PriceQueryRequestDto priceQueryRequestDto = getPriceQueryRequestDto(16, 21);

        mockMvc.perform(post("/price/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(priceQueryRequestDto)))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                {
                  "productId": 35455,
                  "brandName": "ZARA",
                  "price": 38.95,
                  "startDate": "2020-06-15T16:00:00",
                  "endDate": "2020-12-31T23:59:59",
                  "rate": 4
                }"""));
    }

    private PriceQueryRequestDto getPriceQueryRequestDto(int dayOfTheMonth, int hour) {
        return PriceQueryRequestDto.builder()
            .productId(35455)
            .brandName("ZARA")
            .date(LocalDateTime.of(2020, 6, dayOfTheMonth, hour, 0, 0))
            .build();
    }
}
