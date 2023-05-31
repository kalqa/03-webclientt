package com.example.webclientt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ShawnMendesProxy {

    @Autowired
    WebClient webClient;

    // GET https://itunes.apple.com/search?term=shawnmendes&limit=1
    public String makeShawnMendesRequest(String term, int limit) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("itunes.apple.com")
                        .path("/search")
                        .queryParam("term", term)
                        .queryParam("limit", limit)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
