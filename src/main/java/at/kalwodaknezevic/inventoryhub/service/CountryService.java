package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.commands.CountryCommands.CreateCountryCommand;
import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Country;
import at.kalwodaknezevic.inventoryhub.foundation.Base58;
import at.kalwodaknezevic.inventoryhub.persistance.CountryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))

@Service
@Transactional
public class CountryService {
    private final CountryRepository countryRepository;

    @Transactional
    public Country createCountry(CreateCountryCommand command) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("a_" + Base58.random(16));
        } while (countryRepository.findByApiKey(apiKey).isPresent());

        var country = Country.builder()
                .apiKey(apiKey)
                .name(command.name())
                .iso2Code(command.iso2Code())
                .iso3Code(command.iso3Code())
                .areaCode(command.areaCode())
                .build();
        return countryRepository.save(country);
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountry(Long countryId) {
        return countryRepository.findById(new Country.CountryId(countryId));
    }
}
