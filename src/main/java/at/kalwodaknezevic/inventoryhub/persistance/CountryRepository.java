package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Country.CountryId> {
    Optional<Country> findByCountryId(Country.CountryId countryId);
    Optional<Country> findByName(String name);
}