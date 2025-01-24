package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Person {
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "firstname"))
    @NotNull
    private Name firstname;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "lastname"))
    @NotNull
    private Name lastname;

    @NotNull
    private LocalDate birthdate;

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "email"))
    private Email email;

    @Embedded
    @NotNull
    private PhoneNumber phoneNumber;

    @NotNull
    @Embedded
    private Address address;
}