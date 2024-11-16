package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public record Address(
        String street,
        String city,
        String zipCode,
        Country country
) {}
