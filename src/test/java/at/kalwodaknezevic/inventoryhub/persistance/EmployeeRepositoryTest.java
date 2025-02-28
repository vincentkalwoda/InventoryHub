package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.TestcontainersConfiguration;
import at.kalwodaknezevic.inventoryhub.domain.Address;
import at.kalwodaknezevic.inventoryhub.domain.Country;
import at.kalwodaknezevic.inventoryhub.domain.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class EmployeeRepositoryTest {
    private @Autowired EmployeeRepository employeeRepository;
    private Employee employee;

    @BeforeEach
    void setUp() {
        Country austria = FixturesFactory.austria();
        Address address = FixturesFactory.spengergasse20(austria);
        employee = FixturesFactory.johnDoeEmployee(address);
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

    @Test
    void canFindByName() {
        employeeRepository.saveAndFlush(employee);
        var foundEmployee = employeeRepository.findByName(employee.getName());
        assertThat(foundEmployee).isNotEmpty();
        assertThat(foundEmployee).anyMatch(e -> e.getEmployeeId().equals(employee.getEmployeeId()));
    }

    @Test
    void canFindByEmail() {
        employeeRepository.saveAndFlush(employee);
        var foundEmployee = employeeRepository.findByEmail(employee.getEmail());
        assertThat(foundEmployee).isNotEmpty();
        assertThat(foundEmployee.get().getEmployeeId()).isEqualTo(employee.getEmployeeId());
    }
}