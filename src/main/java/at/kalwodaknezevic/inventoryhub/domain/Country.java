package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String iso2Code;
    private String iso3Code;
    private Integer areaCode;

    // Default constructor (required by JPA)
    protected Country() {
    }

    public Country(String name, String iso2Code, String iso3Code, Integer areaCode) {
        if (name == null || name.isEmpty()) {
            throw new CountryException("Name must not be null or empty");
        }
        if (iso2Code == null || !iso2Code.matches("[A-Za-z]{2}")) {
            throw new CountryException("ISO2 code must be exactly 2 letters");
        }
        if (iso3Code == null || !iso3Code.matches("[A-Za-z]{3}")) {
            throw new CountryException("ISO3 code must be exactly 3 letters");
        }
        if (areaCode != null && (areaCode < 0 || areaCode > 999)) {
            throw new CountryException("Area code must be a valid 1-3 digit number");
        }

        this.name = name;
        this.iso2Code = iso2Code;
        this.iso3Code = iso3Code;
        this.areaCode = areaCode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIso2Code() {
        return iso2Code;
    }

    public String getIso3Code() {
        return iso3Code;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public static class CountryException extends RuntimeException {
        public CountryException(String message) {
            super(message);
        }
    }
}