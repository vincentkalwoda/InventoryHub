package at.kalwodaknezevic.inventoryhub.commands;

import at.kalwodaknezevic.inventoryhub.domain.Address;
import at.kalwodaknezevic.inventoryhub.domain.Email;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import at.kalwodaknezevic.inventoryhub.domain.PhoneNumber;

import java.time.LocalDate;

public class EmployeeCommands {
    public record CreateEmployeeCommand(
            Name name,
            LocalDate birthdate,
            Email email,
            PhoneNumber phoneNumber,
            Address address,
            String department,
            String position,
            float salary
    ) {
    }

    public record UpdateEmployeeCommand(
            Long employeeId,
            Name name,
            LocalDate birthdate,
            Email email,
            PhoneNumber phoneNumber,
            Address address,
            String department,
            String position,
            float salary
    ) {
    }

    public record DeleteEmployeeCommand(
            Long employeeId
    ) {
    }
}