package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class EmployeeRepositoryTest {
    private @Autowired EmployeeRepository employeeRepository;
    private Employee employee;

    @BeforeEach
    void setUp() {
        PhoneNumber phoneNumber = new PhoneNumber(43, 1, "4567890", 0, PhoneType.MOBILE);
        Country austria = new Country("Austria", "AT", "AUT", 43);
        Address address = new Address("Teststraße", "1", "1234", austria, AddressType.SHIPPING);
        employee = Employee.builder()
                .firstname("John")
                .lastname("Doe")
                .birthdate(LocalDate.of(1990, 1, 1))
                .email(new Email("john.doe@spg.at"))
                .phoneNumber(phoneNumber)
                .addresses(address)
                .department("IT")
                .position("Developer")
                .salary(5000f)
                .build();
    }


    @Test
    void canSave() {
        assertThat(employeeRepository.saveAndFlush(employee).getEmployeeId()).isNotNull();
    }

    @Test
    void canFindByEmployeeId() {
        employeeRepository.saveAndFlush(employee);
        var foundEmployee = employeeRepository.findByEmployeeId(employee.getEmployeeId());
        assertThat(foundEmployee).isNotEmpty();
        assertThat(foundEmployee.get().getEmployeeId()).isEqualTo(employee.getEmployeeId());
    }
}