package com.example.demo;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class DogImageClient {

    @EventListener(ApplicationReadyEvent.class)
    public String getDogImage() {
        RestTemplate restTemplate = new RestTemplate();

        JsonNode jsonNode = restTemplate.getForObject("https://random.dog/woof.json", JsonNode.class);
        return jsonNode.get("url").asText();

    }
}

