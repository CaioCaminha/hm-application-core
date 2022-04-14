package com.home.manager.hmapplicationcore.service;

import com.home.manager.hmapplicationcore.dto.ComparingProperty;
import com.home.manager.hmapplicationcore.dto.PropertyDto;
import com.home.manager.hmapplicationcore.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface HomeManagerService {

    ResponseEntity<Object> registerProperty(PropertyDto propertyDto);

    ResponseEntity<ResponseDto> comparatePrice(ComparingProperty comparingProperty);


}
