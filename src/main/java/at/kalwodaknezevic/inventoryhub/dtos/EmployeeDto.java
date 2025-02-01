package at.kalwodaknezevic.inventoryhub.dtos;

import at.kalwodaknezevic.inventoryhub.domain.Email;
import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import at.kalwodaknezevic.inventoryhub.domain.PhoneNumber;

import java.time.LocalDate;

public record EmployeeDto(
        String firstname,
        String lastname,
        Email email,
        PhoneNumber phoneNumber,
        LocalDate birthDate) {

    public EmployeeDto(Employee e) {
        this(e.getName().firstname(),
                e.getName().lastname(),
                e.getEmail(),
                e.getPhoneNumber(),
                e.getBirthdate());
    }
}
