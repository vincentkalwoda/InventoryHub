package at.kalwodaknezevic.inventoryhub.presentation.www;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateEmployeeForm {
    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;

    @NotBlank
    @NotNull
    private String email;

    private String phoneNumber;

    private String birthdate;

    private String department;

    private String position;

    private Float salary;
}
