package msscbrewary.brewary.services;

import lombok.extern.slf4j.Slf4j;
import msscbrewary.brewary.web.model.BeerDto;
import msscbrewary.brewary.web.model.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService{
    @Override
    public BeerDto getBeer(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Kingfisher").beerStyle(BeerStyleEnum.ALE).build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
         return BeerDto.builder().id(UUID.randomUUID()).beerName("Kingfisher").beerStyle(BeerStyleEnum.ALE).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //todo implementation of update beer
    }

    @Override
    public void deleteBeer(UUID beerId) {
        //todo implementation of delete beer
        log.debug("Deleting beer " +beerId);
    }
}
