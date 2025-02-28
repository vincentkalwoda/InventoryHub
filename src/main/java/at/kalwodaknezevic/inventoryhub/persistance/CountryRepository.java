package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Country.CountryId> {
    Optional<Country> findByCountryId(Country.CountryId countryId);

    List<Country> findByName(String name);

    Optional<Country> findByApiKey(ApiKey apiKey);
}