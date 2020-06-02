package guru.springframework.msscbeerinventoryservice.web.mappers;

import guru.springframework.msscbeerinventoryservice.domain.BeerInventory;
import guru.springframework.msscbeerinventoryservice.web.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDto);
    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
