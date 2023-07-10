package com.salsatechnology.dto;

import com.salsatechnology.model.ProductType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
public class ProductOrderResponse {

    private Long id;
    private String userName;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private Integer timeHour;
    private Long productValue;
    private Long productTotal;
    private Long userAmount;
}
