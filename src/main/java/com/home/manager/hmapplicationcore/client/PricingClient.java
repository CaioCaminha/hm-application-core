package com.home.manager.hmapplicationcore.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PricingClient {

    private final WebClient webClient;

    public PricingClient(WebClient webClient){
        this.webClient = webClient;
    }




}
