package com.home.manager.hmapplicationcore.service.impl;

import com.home.manager.hmapplicationcore.dto.ComparingProperty;
import com.home.manager.hmapplicationcore.dto.PropertyDto;
import com.home.manager.hmapplicationcore.dto.ResponseDto;
import com.home.manager.hmapplicationcore.service.HomeManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HomeManagerServiceImpl implements HomeManagerService {

    @Override
    public ResponseEntity<ResponseDto> getPrice(PropertyDto propertyDto) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseDto> comparatePrice(ComparingProperty comparingProperty) {
        return null;
    }
}
