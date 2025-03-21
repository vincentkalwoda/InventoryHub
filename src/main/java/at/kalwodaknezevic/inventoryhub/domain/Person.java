package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
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
    @AttributeOverride(name = "value", column = @Column(name = "apiKey"))
    private ApiKey apiKey;

    @Embedded
    @AttributeOverride(name = "firstname", column = @Column(name = "firstname"))
    @AttributeOverride(name = "lastname", column = @Column(name = "lastname"))
    @NotNull
    private Name name;

    private LocalDate birthdate;

    @NotNull
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "email"))
    private Email email;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private Address address;
}