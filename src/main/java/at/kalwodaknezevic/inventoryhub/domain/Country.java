package at.kalwodaknezevic.inventoryhub.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "countries")
public class Country {
    @EmbeddedId
    private CountryId countryId;
    @NotNull
    private String name;
    @NotNull
    private String iso2Code;
    @NotNull
    private String iso3Code;
    @NotNull
    private Integer areaCode;

    @Embeddable
    public record CountryId(@GeneratedValue @NotNull Long countryId) {}

}