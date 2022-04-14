package com.home.manager.hmapplicationcore.constants;

import java.math.BigDecimal;

public enum RegionalPriceEnum {
    SER1(new BigDecimal("4338")),
    SER2(new BigDecimal("5580")),
    SERCEFOR(new BigDecimal("4290")),
    SER3(new BigDecimal("4486")),
    SER4(new BigDecimal("5580")),
    SER5(new BigDecimal("5580")),
    SER6(new BigDecimal("5580"));

    public BigDecimal price;


    RegionalPriceEnum(BigDecimal price){
        this.price = price;
    }
}
