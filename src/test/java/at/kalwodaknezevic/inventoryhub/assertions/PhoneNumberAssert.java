package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.PhoneNumber;
import org.assertj.core.api.AbstractAssert;

public class PhoneNumberAssert extends AbstractAssert<PhoneNumberAssert, PhoneNumber> {
    public PhoneNumberAssert(PhoneNumber phoneNumber) {
        super(phoneNumber, PhoneNumberAssert.class);
    }

    public static PhoneNumberAssert assertThat(PhoneNumber actual) {
        return new PhoneNumberAssert(actual);
    }

    public PhoneNumberAssert hasValidCountryCode() {
        isNotNull();
        if (actual.countryCode() == null || actual.countryCode()<=0) {
            failWithMessage("Expected phone number to have a valid country code, but was null or less than 0");
        }
        return this;
    }

    public PhoneNumberAssert hasValidAreaCode() {
        isNotNull();
        if (actual.areaCode() == null || actual.areaCode()<=0) {
            failWithMessage("Expected phone number to have a valid area code, but was null or less than 0");
        }
        return this;
    }

    public PhoneNumberAssert hasValidSerialCode() {
        isNotNull();
        if (actual.serialCode() == null || actual.serialCode().isEmpty()) {
            failWithMessage("Expected phone number to have a valid serial code, but was null or empty");
        }
        return this;
    }

    public PhoneNumberAssert hasValidExtension() {
        isNotNull();
        if (actual.extension() == null || actual.extension()<0) {
            failWithMessage("Expected phone number to have a valid extension, but was null or less than 0");
        }
        return this;
    }

    public PhoneNumberAssert hasValidPhoneType() {
        isNotNull();
        if (actual.phoneType() == null) {
            failWithMessage("Expected phone number to have a valid phone type, but was null");
        }
        return this;
    }
}
