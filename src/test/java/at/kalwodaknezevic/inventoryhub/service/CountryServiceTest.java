package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.persistance.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {
    private @Mock CountryRepository countryRepository;

    private CountryService countryService;

    @BeforeEach
    void setUp() {
        assumeThat(countryRepository).isNotNull();
        countryService = new CountryService(countryRepository);
    }

    @Test
    void can_create_country() {
        var country = FixturesFactory.austria();
        when(countryRepository.save(country)).thenReturn(country);

        var createdCountry = countryService.createCountry(country.getName(), country.getIso2Code(), country.getIso3Code(), country.getAreaCode());
        assertThat(createdCountry).isEqualTo(country);
    }
}