package com.example.webclientt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class WebclienttApplication {

    @Autowired
    ShawnMendesProxy shawnMendesClient;

    public static void main(String[] args) {
        SpringApplication.run(WebclienttApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToShawnMendesEndpoint(){
        String response = shawnMendesClient.makeShawnMendesRequest("shawnmendes", 5);
        System.out.println(response);
    }
}
