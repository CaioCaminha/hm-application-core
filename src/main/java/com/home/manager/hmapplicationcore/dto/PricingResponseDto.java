package com.home.manager.hmapplicationcore.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PricingResponseDto {
    private PricingDto propertieDto;
    private BigDecimal price;

}
