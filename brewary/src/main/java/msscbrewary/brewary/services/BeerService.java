package msscbrewary.brewary.services;

import msscbrewary.brewary.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface BeerService {

    public BeerDto getBeer(UUID beerId);

    public BeerDto saveBeer(BeerDto beerDto);

    public void updateBeer(UUID beerId, BeerDto beerDto);

    public void deleteBeer(UUID beerId);
}
