package at.kalwodaknezevic.inventoryhub.dtos;

import at.kalwodaknezevic.inventoryhub.domain.Email;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import at.kalwodaknezevic.inventoryhub.domain.PhoneNumber;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;

import java.time.LocalDate;

public record SupplierDto(
        String firstname,
        String lastname,
        Email email,
        PhoneNumber phoneNumber,
        LocalDate birthDate) {

    public SupplierDto(Supplier s) {
        this(s.getName().firstname(),
                s.getName().lastname(),
                s.getEmail(),
                s.getPhoneNumber(),
                s.getBirthdate());
    }
}
