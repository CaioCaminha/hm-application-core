package com.home.manager.hmapplicationcore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private Long statusCode;
    private Object body;
    private List errors;
}
