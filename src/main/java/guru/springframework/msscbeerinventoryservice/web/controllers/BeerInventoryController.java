package guru.springframework.msscbeerinventoryservice.web.controllers;

import guru.springframework.msscbeerinventoryservice.services.BeerInventoryService;
import guru.springframework.msscbeerinventoryservice.web.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerInventoryController {

    private final BeerInventoryService beerInventoryService;

    @GetMapping("/api/v1/beer/{beerId}/inventory")
    public List<BeerInventoryDto> listBeersById(@PathVariable("beerId") UUID beerId) {
        return beerInventoryService.listBeersByBeerId(beerId);
    }
}
