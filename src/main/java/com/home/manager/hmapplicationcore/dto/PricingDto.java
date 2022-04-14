package com.home.manager.hmapplicationcore.dto;

import com.home.manager.hmapplicationcore.constants.RegionalPriceEnum;
import lombok.Data;

@Data
public class PricingDto {
    private String neighborhood;
    private RegionalPriceEnum region;
    private Double size;

    public PricingDto(String neighborhood, RegionalPriceEnum region, Double size){
        this.neighborhood = neighborhood;
        this.region = region;
        this.size = size;
    }
}
