package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import at.kalwodaknezevic.inventoryhub.persistance.converter.PhoneNumberConverter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditSupplierForm {

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
    private String companyName;

    public EditSupplierForm(Supplier supplier) {
        PhoneNumberConverter phoneNumberConverter = new PhoneNumberConverter();
        this.apiKey = supplier.getApiKey();
        this.firstName = supplier.getName().firstname();
        this.lastName = supplier.getName().lastname();
        this.email = supplier.getEmail().value();
        this.phoneNumber = phoneNumberConverter.convertToDatabaseColumn(supplier.getPhoneNumber());
        this.birthdate = supplier.getBirthdate().toString();
        this.companyName = supplier.getCompanyName();
    }
}
