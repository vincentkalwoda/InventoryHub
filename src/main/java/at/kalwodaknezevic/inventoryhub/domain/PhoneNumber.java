package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.*;

@Embeddable
public record PhoneNumber(
        Integer countryCode,
        Integer areaCode,
        String serialCode,
        Integer extension,
        PhoneType phoneType
) {
    public PhoneNumber {
        if (countryCode < 1 || countryCode > 999 || countryCode == null) throw PhoneNumberException.forInvalidCountryCode();
        if (areaCode < 1 || areaCode > 999) throw PhoneNumberException.forInvalidAreaCode();
        if (serialCode == null || serialCode.isBlank()) throw PhoneNumberException.forInvalidSerialCode();
        if (extension < 0 || extension > 9999) throw PhoneNumberException.forInvalidExtension();
        if (phoneType == null) throw PhoneNumberException.forInvalidPhoneType();
    }

    public static class PhoneNumberException extends RuntimeException {
        private PhoneNumberException(String message) {
            super(message);
        }

        static PhoneNumberException forInvalidCountryCode() {
            return new PhoneNumberException("Country code must be between 1 and 999!");
        }

        static PhoneNumberException forInvalidAreaCode() {
            return new PhoneNumberException("Area code must be between 1 and 999!");
        }

        static PhoneNumberException forInvalidSerialCode() {
            return new PhoneNumberException("Serial code must not be null or blank!");
        }

        static PhoneNumberException forInvalidExtension() {
            return new PhoneNumberException("Extension must be between 0 and 9999!");
        }

        static PhoneNumberException forInvalidPhoneType() {
            return new PhoneNumberException("Phone type must not be null or empty!");
        }
    }
}
