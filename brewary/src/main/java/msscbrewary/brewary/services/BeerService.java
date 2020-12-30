package msscbrewary.brewary.services;

import msscbrewary.brewary.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    public BeerDto getBeer(UUID beerId);
}
