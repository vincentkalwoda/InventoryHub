package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.commands.EmployeeCommands.CreateEmployeeCommand;
import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Email;
import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import at.kalwodaknezevic.inventoryhub.foundation.Base58;
import at.kalwodaknezevic.inventoryhub.persistance.EmployeeRepository;
import at.kalwodaknezevic.inventoryhub.presentation.www.CreateEmployeeForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))


@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional
    public Employee createEmployee(CreateEmployeeCommand command) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("e_" + Base58.random(16));
        } while (employeeRepository.findByApiKey(apiKey).isPresent());

        var employee = Employee.builder()
                .apiKey(apiKey)
                .name(command.name())
                .email(command.email())
                .phoneNumber(command.phoneNumber())
                .birthdate(command.birthdate())
                .department(command.department())
                .position(command.position())
                .salary(command.salary())
                .build();
        return employeeRepository.save(employee);
    }

    public Employee createEmployee(CreateEmployeeForm form) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("e_" + Base58.random(16));
        } while (employeeRepository.findByApiKey(apiKey).isPresent());

        var employee = Employee.builder()
                .apiKey(apiKey)
                .name(new Name(form.getFirstName(), form.getLastName()))
                .email(new Email(form.getEmail()))
                .build();

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(new Employee.EmployeeId(employeeId)).get();
        employeeRepository.delete(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Long employeeId) {
        return employeeRepository.findById(new Employee.EmployeeId(employeeId));
    }
}
