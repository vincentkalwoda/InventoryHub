package at.kalwodaknezevic.inventoryhub.presentation.api;

import at.kalwodaknezevic.inventoryhub.dtos.CountryDto;
import at.kalwodaknezevic.inventoryhub.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping(ApiConstants.API+"/countries")
public class CountryRestController {

    private final CountryService countryService;

    @GetMapping()
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAll()
                .stream()
                .map(CountryDto::new)
                .toList());
    }

    @GetMapping("/{countryId}")
    public ResponseEntity<CountryDto> getCountry(@PathVariable Long countryId) {
        return countryService.getCountry(countryId)
                .map(CountryDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
