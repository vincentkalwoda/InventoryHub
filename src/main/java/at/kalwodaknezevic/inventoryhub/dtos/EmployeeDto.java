package at.kalwodaknezevic.inventoryhub.dtos;

import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.domain.PhoneNumber;

import java.time.LocalDate;

public record EmployeeDto(
        String apiKey,
        String firstname,
        String lastname,
        String email,
        PhoneNumber phoneNumber,
        LocalDate birthDate,
        String department,
        String position,
        Float salary
) {

    public EmployeeDto(Employee e) {
        this(
                e.getApiKey().value(),
                e.getName().firstname(),
                e.getName().lastname(),
                e.getEmail().value(),
                e.getPhoneNumber(),
                e.getBirthdate(),
                e.getDepartment(),
                e.getPosition(),
                e.getSalary()
        );
    }
}
