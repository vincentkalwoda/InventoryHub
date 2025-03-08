package at.kalwodaknezevic.inventoryhub.dtos;

import at.kalwodaknezevic.inventoryhub.domain.PhoneNumber;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;

import java.time.LocalDate;

public record SupplierDto(
        String firstname,
        String lastname,
        String email,
        PhoneNumber phoneNumber,
        LocalDate birthDate,
        String companyName
) {

    public SupplierDto(Supplier s) {
        this(s.getName().firstname(),
                s.getName().lastname(),
                s.getEmail().value(),
                s.getPhoneNumber(),
                s.getBirthdate(),
                s.getCompanyName()
        );
    }
}
