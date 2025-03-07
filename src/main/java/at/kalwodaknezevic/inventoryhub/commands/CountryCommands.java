package at.kalwodaknezevic.inventoryhub.commands;

public class CountryCommands {
    public record CreateCountryCommand(
            String name,
            String iso2Code,
            String iso3Code,
            Integer areaCode
    ) {
    }

    public record UpdateCountryCommand(
            Long countryId,
            String name,
            String iso2Code,
            String iso3Code,
            Integer areaCode
    ) {
    }

    public record DeleteCountryCommand(
            Long countryId
    ) {
    }
}