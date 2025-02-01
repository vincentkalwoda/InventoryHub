package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.Address;
import org.assertj.core.api.AbstractAssert;

public class AddressAssert extends AbstractAssert<AddressAssert, Address> {
    public AddressAssert(Address address) {
        super(address, AddressAssert.class);
    }

    public static AddressAssert assertThat(Address actual) {
        return new AddressAssert(actual);
    }

    public AddressAssert hasValidStreet() {
        isNotNull();
        if (actual.street() == null || actual.street().isEmpty()) {
            failWithMessage("Expected address's street to be not null and not empty but was <%s>", actual.street());
        }
        return this;
    }

    public AddressAssert hasValidCity() {
        isNotNull();
        if (actual.city() == null || actual.city().isEmpty()) {
            failWithMessage("Expected address's city to be not null and not empty but was <%s>", actual.city());
        }
        return this;
    }

    public AddressAssert hasValidZipCode() {
        isNotNull();
        if (actual.zipCode() == null || actual.zipCode().isEmpty()) {
            failWithMessage("Expected address's zip code to be not null and not empty but was <%s>", actual.zipCode());
        }
        return this;
    }

    public AddressAssert hasValidCountry() {
        isNotNull();
        if (actual.country() == null || actual.country().toString().isEmpty()) {
            failWithMessage("Expected address's country to be not null and not empty but was <%s>", actual.country());
        }
        return this;
    }

    public AddressAssert hasValidAddressType() {
        isNotNull();
        if (actual.addressType() == null) {
            failWithMessage("Expected address's address type to be not null but was <%s>", actual.addressType());
        }
        return this;
    }
}
