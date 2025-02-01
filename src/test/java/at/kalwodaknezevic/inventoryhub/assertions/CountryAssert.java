package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.Country;
import org.assertj.core.api.AbstractAssert;

public class CountryAssert extends AbstractAssert<CountryAssert, Country> {
    public CountryAssert(Country country) {
        super(country, CountryAssert.class);
    }

    public static CountryAssert assertThat(Country actual) {
        return new CountryAssert(actual);
    }

    public CountryAssert hasValidName() {
        isNotNull();
        if (actual.getName() == null || actual.getName().isEmpty()) {
            failWithMessage("Expected country's name to be not null and not empty but was <%s>", actual.getName());
        }
        return this;
    }

    public CountryAssert hasValidIso2Code() {
        isNotNull();
        if (actual.getIso2Code() == null || actual.getIso2Code().isEmpty()) {
            failWithMessage("Expected country's iso2code to be not null and not empty but was <%s>", actual.getIso2Code());
        }
        return this;
    }

    public CountryAssert hasValidIso3Code() {
        isNotNull();
        if (actual.getIso3Code() == null || actual.getIso3Code().isEmpty()) {
            failWithMessage("Expected country's iso3code to be not null and not empty but was <%s>", actual.getIso3Code());
        }
        return this;
    }

    public CountryAssert hasValidAreaCode() {
        isNotNull();
        if (actual.getAreaCode() == null || actual.getAreaCode() <= 0) {
            failWithMessage("Expected country's areaCode to be greater than 0 but was <%s>", actual.getAreaCode());
        }
        return this;
    }
}
