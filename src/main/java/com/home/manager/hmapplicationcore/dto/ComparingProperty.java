package com.home.manager.hmapplicationcore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComparingProperty {

    @NotEmpty
    private String neighborhood;

    @NotEmpty
    private BigDecimal size;

    @NotEmpty
    private BigDecimal amount;
}
