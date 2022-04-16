package com.home.manager.hmapplicationcore.service.impl;

import com.google.gson.Gson;
import com.home.manager.hmapplicationcore.dto.*;
import com.home.manager.hmapplicationcore.entity.NeighborhoodEntity;
import com.home.manager.hmapplicationcore.publisher.SqsPublisher;
import com.home.manager.hmapplicationcore.repository.NeighborhoodRepository;
import com.home.manager.hmapplicationcore.service.HomeManagerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ExecutionException;

@Service
public class HomeManagerServiceImpl implements HomeManagerService {

    private SqsPublisher sqsPublisher;

    private NeighborhoodRepository repository;

    private WebClient webClient;

    private final String pricingUrl = "https://l459kl9if8.execute-api.us-east-1.amazonaws.com/prod";

    public HomeManagerServiceImpl(WebClient.Builder webClientBuilder, SqsPublisher sqsPublisher, NeighborhoodRepository neighborhoodRepository){
        this.sqsPublisher = sqsPublisher;
        repository = neighborhoodRepository;
        webClient = webClientBuilder.build();
    }


    @Override
    public ResponseEntity<Object> registerProperty(PropertyDto propertyDto) throws Exception {
        Gson gson = new Gson();
        NeighborhoodEntity propertie = new NeighborhoodEntity();
        Optional<NeighborhoodEntity> optionalPropertie = repository.findByName(propertyDto.getNeighborhood());
        Message message = new Message();


        if(optionalPropertie.isPresent()){
            propertie = optionalPropertie.get();
            PricingDto pricingDto = new PricingDto(propertyDto.getNeighborhood(), propertie.getRegion(), propertyDto.getSize());
            PricingResponseDto response = webClient.post()
                                    .uri(pricingUrl)
                                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                    .body(Mono.just(pricingDto), PricingDto.class)
                                    .retrieve()
                                    .bodyToMono(PricingResponseDto.class).toFuture().get();

            message.setId(String.valueOf(Math.random()));
            message.setBody(gson.toJson(response));
            this.sqsPublisher.sendMessage(message);


            return ResponseEntity.created(new URI("")).body(response);
        }else {
            throw new Exception("Was not possible get the response from princing API");
        }
    }

    @Override
    public ResponseEntity<ResponseDto> comparatePrice(ComparingProperty comparingProperty) {
        return null;
    }
}
