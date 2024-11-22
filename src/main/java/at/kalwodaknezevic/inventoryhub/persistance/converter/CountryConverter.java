package at.kalwodaknezevic.inventoryhub.persistance.converter;

import at.kalwodaknezevic.inventoryhub.domain.Country;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CountryConverter implements AttributeConverter<Country, String> {

    @Override
    public String convertToDatabaseColumn(Country country) {
        return null;
    }

    @Override
    public Country convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        String name;
        String iso2Code;
        String iso3Code;
        Integer areaCode = null;

        int length = dbData.length();
        if (length > 3 && Character.isDigit(dbData.charAt(length - 1)) && Character.isDigit(dbData.charAt(length - 2)) && Character.isDigit(dbData.charAt(length - 3))) {
            areaCode = Integer.parseInt(dbData.substring(length - 3));
            iso3Code = dbData.substring(length - 6, length - 3);
            iso2Code = dbData.substring(length - 8, length - 6);
            name = dbData.substring(0, length - 8);
        } else if (length > 2 && Character.isDigit(dbData.charAt(length - 1)) && Character.isDigit(dbData.charAt(length - 2))) {
            areaCode = Integer.parseInt(dbData.substring(length - 2));
            iso3Code = dbData.substring(length - 5, length - 2);
            iso2Code = dbData.substring(length - 7, length - 5);
            name = dbData.substring(0, length - 7);
        } else if (length > 1 && Character.isDigit(dbData.charAt(length - 1))) {
            areaCode = Integer.parseInt(dbData.substring(length - 1));
            iso3Code = dbData.substring(length - 4, length - 1);
            iso2Code = dbData.substring(length - 6, length - 4);
            name = dbData.substring(0, length - 6);
        } else {
            iso3Code = dbData.substring(length - 3);
            iso2Code = dbData.substring(length - 5, length - 3);
            name = dbData.substring(0, length - 5);
        }

        return new Country(name, iso2Code, iso3Code, areaCode);
    }
}