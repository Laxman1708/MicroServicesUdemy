package msscbrewery.client.web.client;

import msscbrewery.client.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreInvalidFields = false)
public class BreweryClient {

    private RestTemplate restTemplate;
    private final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apiHost;


    public BreweryClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public BeerDto getBeer(UUID uuid) {
        return restTemplate.getForObject(apiHost+BEER_PATH_V1+uuid.toString(), BeerDto.class);
    }

    public URI saveBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apiHost+BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto) {
         restTemplate.put(apiHost+BEER_PATH_V1+uuid.toString(), beerDto);
    }

    public void deleteBear(UUID uuid){
        restTemplate.delete(apiHost+BEER_PATH_V1+uuid);
    }

}
