package com.home.manager.hmapplicationcore.service;

import com.home.manager.hmapplicationcore.dto.ComparingProperty;
import com.home.manager.hmapplicationcore.dto.PropertyDto;
import com.home.manager.hmapplicationcore.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public interface HomeManagerService {

    ResponseEntity<Object> registerProperty(PropertyDto propertyDto) throws Exception;

    ResponseEntity<ResponseDto> comparatePrice(ComparingProperty comparingProperty);


}
