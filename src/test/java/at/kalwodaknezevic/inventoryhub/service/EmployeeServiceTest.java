package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.persistance.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void can_get_all_employees() {
        var address = FixturesFactory.spengergasse20(FixturesFactory.austria());
        var employee = FixturesFactory.johnDoeEmployee(address);
        when(employeeRepository.findAll()).thenReturn(List.of(employee));

        var employees = employeeService.getAll();
        assertThat(employees).containsExactly(employee);
    }

    @Test
    void can_get_employee() {
        var address = FixturesFactory.spengergasse20(FixturesFactory.austria());
        var employee = FixturesFactory.johnDoeEmployee(address);
        when(employeeRepository.findById(employee.getEmployeeId())).thenReturn(java.util.Optional.of(employee));

        var foundEmployee = employeeService.getEmployee(employee.getEmployeeId());
        assertThat(foundEmployee).isPresent().contains(employee);
    }
}