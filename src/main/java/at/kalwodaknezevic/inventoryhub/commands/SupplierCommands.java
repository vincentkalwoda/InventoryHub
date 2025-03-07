package at.kalwodaknezevic.inventoryhub.commands;

import at.kalwodaknezevic.inventoryhub.domain.Address;
import at.kalwodaknezevic.inventoryhub.domain.Email;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import at.kalwodaknezevic.inventoryhub.domain.PhoneNumber;

import java.time.LocalDate;

public class SupplierCommands {
    public record CreateSupplierCommand(
            Name name,
            LocalDate birthdate,
            Email email,
            PhoneNumber phoneNumber,
            Address address,
            String companyName
    ) {
    }

    public record UpdateSupplierCommand(
            Long supplierId,
            Name name,
            LocalDate birthdate,
            Email email,
            PhoneNumber phoneNumber,
            Address address,
            String companyName
    ) {
    }

    public record DeleteSupplierCommand(
            Long supplierId
    ) {
    }
}