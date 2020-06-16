package guru.springframework.msscbeerinventoryservice.services;

import guru.springframework.msscbeerinventoryservice.repositories.BeerInventoryRepository;
import guru.springframework.msscbeerinventoryservice.web.mappers.BeerInventoryMapper;
import guru.sfg.brewery.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeerInventoryServiceImpl implements BeerInventoryService {

    private final BeerInventoryRepository beerInventoryRepository;
    private final BeerInventoryMapper beerInventoryMapper;

    @Override
    public List<BeerInventoryDto> listBeersByBeerId(UUID beerId) {
        return beerInventoryRepository.findAllByBeerId(beerId).stream()
                .map(beerInventoryMapper::beerInventoryToBeerInventoryDto)
                .collect(Collectors.toList());
    }
}
