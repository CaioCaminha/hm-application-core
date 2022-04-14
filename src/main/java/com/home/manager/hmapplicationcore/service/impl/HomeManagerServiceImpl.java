package com.home.manager.hmapplicationcore.service.impl;

import com.google.gson.Gson;
import com.home.manager.hmapplicationcore.dto.*;
import com.home.manager.hmapplicationcore.entity.NeighborhoodEntity;
import com.home.manager.hmapplicationcore.publisher.SqsPublisher;
import com.home.manager.hmapplicationcore.repository.NeighborhoodRepository;
import com.home.manager.hmapplicationcore.service.HomeManagerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class HomeManagerServiceImpl implements HomeManagerService {

    private SqsPublisher sqsPublisher;

    private NeighborhoodRepository repository;

    private WebClient webClient;


    public HomeManagerServiceImpl(WebClient webClient, SqsPublisher sqsPublisher, NeighborhoodRepository neighborhoodRepository){
        sqsPublisher = sqsPublisher;
        repository = neighborhoodRepository;
        webClient = webClient;
    }


    @Override
    public ResponseEntity<Object> registerProperty(PropertyDto propertyDto) {
        NeighborhoodEntity propertie = new NeighborhoodEntity();
        Optional<NeighborhoodEntity> optionalPropertie = repository.findByName(propertyDto.getNeighborhood());

        if(optionalPropertie.isPresent()){
            propertie = optionalPropertie.get();
            PricingDto pricingDto = new PricingDto(propertyDto.getNeighborhood(), propertie.getRegion(), propertyDto.getSize());
            webClient.post()
                    .uri("/pricing")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(Mono.just(pricingDto), PricingDto.class)
                    .retrieve()
                    .bodyToMono(PricingResponseDto.class);
        }
        return null;
    }

    @Override
    public ResponseEntity<ResponseDto> comparatePrice(ComparingProperty comparingProperty) {
        return null;
    }
}
