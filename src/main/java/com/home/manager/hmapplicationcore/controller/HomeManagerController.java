package com.home.manager.hmapplicationcore.controller;

import com.home.manager.hmapplicationcore.dto.ComparingProperty;
import com.home.manager.hmapplicationcore.dto.PropertyDto;
import com.home.manager.hmapplicationcore.dto.ResponseDto;
import com.home.manager.hmapplicationcore.service.HomeManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "v1/home/manager/pricing")
public class HomeManagerController {

    private HomeManagerService hmService;

    public HomeManagerController(HomeManagerService homeManagerService){
        this.hmService = homeManagerService;
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getPrice(@RequestBody PropertyDto propertyDto){
        try{
            return this.hmService.getPrice(propertyDto);
        }catch (Exception e){
            List<String> errors = new ArrayList<String>();
            errors.add(e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseDto(400L, "Bad Request, review and try again", errors));
        }
    }

    @GetMapping("/compare")
    public ResponseEntity<ResponseDto> comparePrice(@RequestBody ComparingProperty comparingProperty){
        try{
            return this.hmService.comparatePrice(comparingProperty);
        }catch (Exception e){
            List<String> errors = new ArrayList<String>();
            errors.add(e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseDto(400L, "Bad Request, review and try again", errors));
        }
    }


}
