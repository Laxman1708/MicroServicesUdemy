package msscbrewery.client.web.client;

import msscbrewery.client.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;
    @Test
    void getBeer() {
        BeerDto beerDto = breweryClient.getBeer(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("Laxman's beer").build();
        URI uri = breweryClient.saveBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeerTest(){
        BeerDto beerDto = BeerDto.builder().beerName("Laxman's beer").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBear(){
        breweryClient.deleteBear(UUID.randomUUID());
    }
}