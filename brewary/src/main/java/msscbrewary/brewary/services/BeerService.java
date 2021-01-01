package msscbrewary.brewary.services;

import msscbrewary.brewary.web.model.BeerDto;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public interface BeerService {

    public BeerDto getBeer(UUID beerId);

    public BeerDto saveBeer(BeerDto beerDto);
}
