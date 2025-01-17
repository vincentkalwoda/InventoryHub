package at.kalwodaknezevic.inventoryhub.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor

@MappedSuperclass
public abstract class Person {
    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private LocalDate birthdate;

    @NotNull
    @Embedded
    private Email email;

    @Embedded
    @NotNull
    private PhoneNumber phoneNumber;

    @NotNull
    @Embedded
    private Address address;

    protected Person( String firstname, String lastname, LocalDate birthdate, Email email, PhoneNumber phoneNumber, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}