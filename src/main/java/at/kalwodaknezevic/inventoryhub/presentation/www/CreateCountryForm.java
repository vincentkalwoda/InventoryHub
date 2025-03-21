package at.kalwodaknezevic.inventoryhub.presentation.www;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCountryForm {
    @NotBlank
    private String name;

    @NotBlank
    @NotNull
    private String iso2Code;

    @NotBlank
    @NotNull
    private String iso3Code;

    @NotNull
    private Integer areaCode;
}
