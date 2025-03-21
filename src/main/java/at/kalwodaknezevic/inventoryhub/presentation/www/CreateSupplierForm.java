package at.kalwodaknezevic.inventoryhub.presentation.www;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateSupplierForm {
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

    @NotBlank
    @NotNull
    private String companyName;
}
