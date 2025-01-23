package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.domain.Country;
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
        var country = Country.builder()
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
