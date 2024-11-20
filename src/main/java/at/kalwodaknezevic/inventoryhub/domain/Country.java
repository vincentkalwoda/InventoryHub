package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.AbstractPersistable;

/*
 * Represents a type-safe Country following the rules below:
 *
 * - does not accept null values
 * - Iso2Code must be exactly 2 characters
 * - Iso3Code must be exactly 3 characters
 *
 * @param name
 * @param iso2Code
 * @param iso3Code
 * @param areaCode
 * @throws CountryException
 */
@Entity
@Table(name = "countries")
public record Country(
        @NotNull String name,
        @NotNull @Column(length = ISO2_CODE_LENGTH) String iso2Code,
        @NotNull @Column(length = ISO3_CODE_LENGTH) String iso3Code,
        Integer areaCode
) {

    private static final int ISO2_CODE_LENGTH = 2;
    private static final int ISO3_CODE_LENGTH = 3;

    public Country {
        if (name == null || name.isEmpty()) throw new CountryException("Name must not be null or empty");
        if (iso2Code == null || iso2Code.length() != ISO2_CODE_LENGTH) throw new CountryException("ISO2 code must be exactly " + ISO2_CODE_LENGTH + " characters");
        if (iso3Code == null || iso3Code.length() != ISO3_CODE_LENGTH) throw new CountryException("ISO3 code must be exactly " + ISO3_CODE_LENGTH + " characters");
        if (areaCode != null && (areaCode < 1 || areaCode > 999)) throw new CountryException("Area code must be a valid 1-3 digit number");
    }

    public Country(String dbString) {
        if (dbString == null || dbString.isEmpty()) throw new CountryException("Input string must not be null or empty");

        int firstDigitIndex = -1;
        for (int i = 0; i < dbString.length(); i++) {
            if (Character.isDigit(dbString.charAt(i))) {
                firstDigitIndex = i;
                break;
            }
        }

        if (firstDigitIndex == -1 || firstDigitIndex + ISO2_CODE_LENGTH + ISO3_CODE_LENGTH > dbString.length()) {
            throw new CountryException("Input string does not contain valid ISO codes or area code");
        }

        String name = dbString.substring(0, firstDigitIndex);
        String iso2Code = dbString.substring(firstDigitIndex, firstDigitIndex + ISO2_CODE_LENGTH);
        String iso3Code = dbString.substring(firstDigitIndex + ISO2_CODE_LENGTH, firstDigitIndex + ISO2_CODE_LENGTH + ISO3_CODE_LENGTH);
        String areaCodeStr = dbString.substring(firstDigitIndex + ISO2_CODE_LENGTH + ISO3_CODE_LENGTH);

        Integer areaCode = null;
        if (!areaCodeStr.isEmpty()) {
            try {
                areaCode = Integer.parseInt(areaCodeStr);
                if (areaCode < 1 || areaCode > 999) {
                    throw new CountryException("Area code must be a valid 1-3 digit number");
                }
            } catch (NumberFormatException e) {
                throw new CountryException("Area code must be a valid 1-3 digit number");
            }
        }

        if (name.isEmpty()) throw new CountryException("Name must not be empty");
        if (iso2Code.length() != ISO2_CODE_LENGTH) throw new CountryException("ISO2 code must be exactly " + ISO2_CODE_LENGTH + " characters");
        if (iso3Code.length() != ISO3_CODE_LENGTH) throw new CountryException("ISO3 code must be exactly " + ISO3_CODE_LENGTH + " characters");

        this.name = name;
        this.iso2Code = iso2Code;
        this.iso3Code = iso3Code;
        this.areaCode = areaCode;
    }

    public static class CountryException extends RuntimeException {
        private CountryException(String message) {
            super(message);
        }
    }
}