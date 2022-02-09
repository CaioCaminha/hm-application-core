package com.home.manager.hmapplicationcore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
    private BigDecimal amount;
    private BigDecimal neighborhoodAmmount;
}
