package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.commands.CountryCommands.CreateCountryCommand;
import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Country;
import at.kalwodaknezevic.inventoryhub.persistance.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {
    private @Mock CountryRepository countryRepository;

    private CountryService countryService;
    private Country country;
    private CreateCountryCommand createCountryCommand;

    @BeforeEach
    void setUp() {
        assumeThat(countryRepository).isNotNull();
        countryService = new CountryService(countryRepository);
        country = FixturesFactory.austria();
        createCountryCommand = FixturesFactory.createCountryCommand(country);
    }

    @Test
    void can_create_country() {
        when(countryRepository.findByApiKey(any(ApiKey.class))).thenReturn(Optional.empty());
        when(countryRepository.save(any(Country.class))).thenReturn(country);

        var createdCountry = countryService.createCountry(createCountryCommand);
        assertThat(createdCountry).isEqualTo(country);
    }
}