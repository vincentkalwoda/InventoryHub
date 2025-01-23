package at.kalwodaknezevic.inventoryhub.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@NoArgsConstructor
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

    @Builder
    public Country(CountryId countryId,String name, String iso2Code, String iso3Code, Integer areaCode) {
        this.countryId = countryId;
        this.name = name;
        this.iso2Code = iso2Code;
        this.iso3Code = iso3Code;
        this.areaCode = areaCode;
    }

    @Embeddable
    public record CountryId(@GeneratedValue @NotNull Long countryId) {}

}