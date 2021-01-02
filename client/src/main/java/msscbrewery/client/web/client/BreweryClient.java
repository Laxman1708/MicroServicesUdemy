package msscbrewery.client.web.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BreweryClient {

    private RestTemplateBuilder restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate;
    }
}
