package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CountryRepositoryTest {
    private @Autowired CountryRepository countryRepository;
    private Country country;

    @BeforeEach
    void setUp() {
        country = Country.builder()
                .name("Austria")
                .iso2Code("AT")
                .iso3Code("AUT")
                .areaCode(43)
                .build();
    }

    @Test
    void canSave() {
        assertThat(countryRepository.saveAndFlush(country).getId()).isNotNull();
    }

    @Test
    void canFindByName() {
        countryRepository.saveAndFlush(country);
        var foundCountry = countryRepository.findByName(country.getName());
        assertThat(foundCountry).isNotEmpty();
        assertThat(foundCountry.get().getName()).isEqualTo(country.getName());
    }
}