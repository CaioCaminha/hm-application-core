package com.home.manager.hmapplicationcore.controller;

import com.home.manager.hmapplicationcore.dto.PropertyDto;
import com.home.manager.hmapplicationcore.dto.ResponseDto;
import com.home.manager.hmapplicationcore.publisher.SqsPublisher;
import com.home.manager.hmapplicationcore.service.HomeManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "v1/home/manager/property")
public class HomeManagerController {

    private SqsPublisher publisher;

    private HomeManagerService hmService;

    public HomeManagerController(HomeManagerService homeManagerService, SqsPublisher publisher){
        this.hmService = homeManagerService;
        this.publisher = publisher;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> getPrice(@RequestBody PropertyDto propertyDto){
        try{
            return this.hmService.registerProperty(propertyDto);
        }catch (Exception e){
            List<String> errors = new ArrayList<String>();
            errors.add(e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseDto(400L, "Bad Request, review and try again", errors));
        }
    }


}
