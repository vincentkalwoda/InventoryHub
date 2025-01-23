package at.kalwodaknezevic.inventoryhub.dtos;

import at.kalwodaknezevic.inventoryhub.domain.Country;

public record CountryDto(
        String name,
        String iso2Code,
        String iso3Code,
        Integer areaCode) {

    public CountryDto(Country c) {
        this(c.getName(),
                c.getIso2Code(),
                c.getIso3Code(),
                c.getAreaCode());
    }
}
