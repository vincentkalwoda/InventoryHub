package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.TestcontainersConfiguration;
import at.kalwodaknezevic.inventoryhub.domain.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class CountryRepositoryTest {
    private @Autowired CountryRepository countryRepository;
    private final Country country = FixturesFactory.austria();

    @Test
    void canSave() {
        assertThat(countryRepository.saveAndFlush(country).getCountryId()).isNotNull();
    }

    @Test
    void canFindById() {
        countryRepository.saveAndFlush(country);
        var foundCountry = countryRepository.findByCountryId(country.getCountryId());
        assertThat(foundCountry).isNotEmpty();
        assertThat(foundCountry.get().getCountryId()).isEqualTo(country.getCountryId());
    }

    @Test
    void canFindByName() {
        countryRepository.saveAndFlush(country);
        var foundCountry = countryRepository.findByName(country.getName());
        assertThat(foundCountry).isNotEmpty();
        assertThat(foundCountry.get().getName()).isEqualTo(country.getName());
    }
}