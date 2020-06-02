package guru.springframework.msscbeerinventoryservice.services;

import guru.springframework.msscbeerinventoryservice.web.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

public interface BeerInventoryService {

    List<BeerInventoryDto> listBeersByBeerId(UUID beerId);
}
