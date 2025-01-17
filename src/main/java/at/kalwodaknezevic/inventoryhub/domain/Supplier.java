package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "suppliers")
public class Supplier extends Person {

    @EmbeddedId
    private SupplierId supplierId;

    @NotNull
    private String companyName;

    @Embeddable
    public record SupplierId(@GeneratedValue @NotNull Long id) {
    }
}