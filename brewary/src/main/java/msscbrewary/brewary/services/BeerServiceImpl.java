package msscbrewary.brewary.services;

import msscbrewary.brewary.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService{
    @Override
    public BeerDto getBeer(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Kingfisher").beerStyle("Strong").build();
    }
}
