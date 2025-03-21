package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.commands.CountryCommands.CreateCountryCommand;
import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Country;
import at.kalwodaknezevic.inventoryhub.foundation.Base58;
import at.kalwodaknezevic.inventoryhub.persistance.CountryRepository;
import at.kalwodaknezevic.inventoryhub.presentation.www.CreateCountryForm;
import at.kalwodaknezevic.inventoryhub.presentation.www.EditCountryForm;
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

    public Country createCountry(CreateCountryForm form) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("a_" + Base58.random(16));
        } while (countryRepository.findByApiKey(apiKey).isPresent());

        var country = Country.builder()
                .apiKey(apiKey)
                .name(form.getName())
                .iso2Code(form.getIso2Code())
                .iso3Code(form.getIso3Code())
                .areaCode(form.getAreaCode())
                .build();

        return countryRepository.save(country);
    }

    public Country updateCountry(Country country) {
        Country countryToUpdate = countryRepository.findByApiKey(country.getApiKey()).get();
        countryToUpdate.setName(country.getName());
        countryToUpdate.setIso2Code(country.getIso2Code());
        countryToUpdate.setIso3Code(country.getIso3Code());
        countryToUpdate.setAreaCode(country.getAreaCode());
        return countryRepository.save(countryToUpdate);
    }

    public Country updateCountry(EditCountryForm form) {
        Country countryToUpdate = countryRepository.findByApiKey(new ApiKey(form.getApiKey().value())).get();
        countryToUpdate.setName(form.getName());
        countryToUpdate.setIso2Code(form.getIso2Code());
        countryToUpdate.setIso3Code(form.getIso3Code());
        countryToUpdate.setAreaCode(form.getAreaCode());
        return countryRepository.save(countryToUpdate);
    }

    public void deleteCountry(String apiKey) {
        Country country = countryRepository.findByApiKey(new ApiKey(apiKey)).get();
        countryRepository.delete(country);
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountry(String apiKey) {
        return countryRepository.findByApiKey(new ApiKey(apiKey));
    }
}
