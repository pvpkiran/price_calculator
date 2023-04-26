package com.inditex.pricecalculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Brand {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "brand_seq_gen")
    @SequenceGenerator(sequenceName = "brand_seq", allocationSize = 1, name = "brand_seq_gen")
    private long id;

    private String brandName;
    private int brandId;
}
