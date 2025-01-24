package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "suppliers")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Supplier extends Person {

    @EmbeddedId
    private SupplierId supplierId;

    @NotNull
    private String companyName;

    @Embeddable
    public record SupplierId(@GeneratedValue @NotNull Long id) {
    }
}