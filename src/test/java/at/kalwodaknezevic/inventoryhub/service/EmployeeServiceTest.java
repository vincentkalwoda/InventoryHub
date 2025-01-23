package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.persistance.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    private @Mock EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        assumeThat(employeeRepository).isNotNull();
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    void can_create_employee() {
        var address = FixturesFactory.spengergasse20(FixturesFactory.austria());
        var employee = FixturesFactory.johnDoeEmployee(address);
        when(employeeRepository.save(employee)).thenReturn(employee);

        var createdEmployee = employeeService.createEmployee(employee.getFirstname(), employee.getLastname(), employee.getEmail(), employee.getPhoneNumber(), employee.getBirthdate(), employee.getDepartment(), employee.getPosition(), employee.getSalary());
        assertThat(createdEmployee).isEqualTo(employee);
    }
}