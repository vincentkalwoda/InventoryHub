package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.commands.EmployeeCommands.CreateEmployeeCommand;
import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Email;
import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import at.kalwodaknezevic.inventoryhub.foundation.Base58;
import at.kalwodaknezevic.inventoryhub.persistance.EmployeeRepository;
import at.kalwodaknezevic.inventoryhub.persistance.converter.PhoneNumberConverter;
import at.kalwodaknezevic.inventoryhub.presentation.www.CreateEmployeeForm;
import at.kalwodaknezevic.inventoryhub.presentation.www.EditEmployeeForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                .phoneNumber(new PhoneNumberConverter().convertToEntityAttribute(form.getPhoneNumber()))
                .birthdate(LocalDate.parse(form.getBirthdate()))
                .department(form.getDepartment())
                .position(form.getPosition())
                .build();

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        Employee employeeToUpdate = employeeRepository.findByApiKey(employee.getApiKey()).get();
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setEmail(employee.getEmail());
        employeeToUpdate.setPhoneNumber(employee.getPhoneNumber());
        employeeToUpdate.setBirthdate(employee.getBirthdate());
        employeeToUpdate.setDepartment(employee.getDepartment());
        employeeToUpdate.setPosition(employee.getPosition());
        employeeToUpdate.setSalary(employee.getSalary());
        return employeeRepository.save(employeeToUpdate);
    }

    public Employee updateEmployee(EditEmployeeForm form) {
        PhoneNumberConverter phoneNumberConverter = new PhoneNumberConverter();
        Employee employeeToUpdate = employeeRepository.findByApiKey(new ApiKey(form.getApiKey().value())).get();
        employeeToUpdate.setName(new Name(form.getFirstName(), form.getLastName()));
        employeeToUpdate.setEmail(new Email(form.getEmail()));
        employeeToUpdate.setPhoneNumber(phoneNumberConverter.convertToEntityAttribute(form.getPhoneNumber()));
        employeeToUpdate.setBirthdate(LocalDate.parse(form.getBirthdate()));
        employeeToUpdate.setDepartment(form.getDepartment());
        employeeToUpdate.setPosition(form.getPosition());
        employeeToUpdate.setSalary(form.getSalary());
        return employeeRepository.save(employeeToUpdate);
    }

    public void deleteEmployee(String apiKey) {
        Employee employee = employeeRepository.findByApiKey(new ApiKey(apiKey)).get();
        employeeRepository.delete(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(String apiKey) {
        return employeeRepository.findByApiKey(new ApiKey(apiKey));
    }
}
