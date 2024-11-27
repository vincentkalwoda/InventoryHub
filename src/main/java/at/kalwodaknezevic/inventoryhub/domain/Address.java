package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Embeddable
public record Address(
        String street,
        String city,
        String zipCode,
        @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinColumn(foreignKey = @ForeignKey(name = "FK_person_address_country"))
        Country country,
        AddressType addressType
) {
    public Address {
        if (street == null) throw AddressException.forNullStreet();
        if (city == null) throw AddressException.forNullCity();
        if (zipCode == null) throw AddressException.forNullZipCode();
        if (country == null) throw AddressException.forNullCountry();
        if(addressType == null) throw AddressException.forNullAddressType();
    }

    public static class AddressException extends RuntimeException {
        private AddressException(String message) {
            super(message);
        }

        static AddressException forNullStreet() {
            return new AddressException("Street must not be null!");
        }

        static AddressException forNullCity() {
            return new AddressException("City must not be null!");
        }

        static AddressException forNullZipCode() {
            return new AddressException("Zip code must not be null!");
        }

        static AddressException forNullCountry() {
            return new AddressException("Country must not be null!");
        }

        static AddressException forNullAddressType() {
            return new AddressException("Address type must not be null!");
        }
    }
}
