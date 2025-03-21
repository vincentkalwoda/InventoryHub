package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.persistance.converter.PhoneNumberConverter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditEmployeeForm {

    @NotNull
    private ApiKey apiKey;

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;

    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    private String phoneNumber;

    @NotBlank
    @NotNull
    private String birthdate;

    @NotBlank
    @NotNull
    private String department;

    @NotBlank
    @NotNull
    private String position;

    @NotNull
    private Float salary;

    public EditEmployeeForm(Employee employee) {
        PhoneNumberConverter phoneNumberConverter = new PhoneNumberConverter();
        this.apiKey = employee.getApiKey();
        this.firstName = employee.getName().firstname();
        this.lastName = employee.getName().lastname();
        this.email = employee.getEmail().value();
        this.phoneNumber = phoneNumberConverter.convertToDatabaseColumn(employee.getPhoneNumber());
        this.birthdate = employee.getBirthdate().toString();
        this.department = employee.getDepartment();
        this.position = employee.getPosition();
        this.salary = employee.getSalary();
    }
}
