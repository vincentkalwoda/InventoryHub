package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditCountryForm {

    @NotNull
    private ApiKey apiKey;

    @NotBlank
    private String name;

    @NotBlank
    @NotNull
    private String iso2Code;

    @NotBlank
    @NotNull
    private String iso3Code;

    @NotBlank
    @NotNull
    private Integer areaCode;

    public EditCountryForm(Country country) {
        this.apiKey = country.getApiKey();
        this.name = country.getName();
        this.iso2Code = country.getIso2Code();
        this.iso3Code = country.getIso3Code();
        this.areaCode = country.getAreaCode();
    }
}
