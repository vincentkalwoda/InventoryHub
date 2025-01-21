package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee extends Person {
    @EmbeddedId
    private EmployeeId employeeId;

    @NotNull
    private String department;

    @NotNull
    private String position;

    @NotNull
    private float salary;

    @OneToMany(mappedBy = "employees")
    private List<Order> orders;

    @Embeddable
    public record EmployeeId(@GeneratedValue @NotNull Long id) {
    }
}
