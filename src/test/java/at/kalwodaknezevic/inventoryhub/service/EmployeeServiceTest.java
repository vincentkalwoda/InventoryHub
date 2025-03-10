package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.commands.EmployeeCommands.CreateEmployeeCommand;
import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.persistance.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    private @Mock EmployeeRepository employeeRepository;

    private EmployeeService employeeService;
    private Employee employee;
    private CreateEmployeeCommand createEmployeeCommand;

    @BeforeEach
    void setUp() {
        assumeThat(employeeRepository).isNotNull();
        employeeService = new EmployeeService(employeeRepository);
        employee = FixturesFactory.johnDoeEmployee(FixturesFactory.spengergasse20(FixturesFactory.austria()));
        createEmployeeCommand = FixturesFactory.createEmployeeCommand(employee);
    }

    @Test
    void can_create_employee() {
        when(employeeRepository.findByApiKey(any(ApiKey.class))).thenReturn(Optional.empty());
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        var createdEmployee = employeeService.createEmployee(createEmployeeCommand);
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

        var foundEmployee = employeeService.getEmployee(employee.getEmployeeId().id());
        assertThat(foundEmployee).isPresent().contains(employee);
    }
}