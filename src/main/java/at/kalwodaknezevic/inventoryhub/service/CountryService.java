package at.kalwodaknezevic.inventoryhub.service;

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
    public Country createCountry(String name, String iso2Code, String iso3Code, Integer areaCode) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("a_" + Base58.random(10));
        } while (countryRepository.findByApiKey(apiKey).isPresent());

        var country = Country.builder()
                .apiKey(apiKey)
                .name(name)
                .iso2Code(iso2Code)
                .iso3Code(iso3Code)
                .areaCode(areaCode)
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
