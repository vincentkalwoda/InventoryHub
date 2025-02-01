package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.domain.*;
import at.kalwodaknezevic.inventoryhub.persistance.EmployeeRepository;
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
    public Employee createEmployee(Name name, Email email, PhoneNumber phoneNumber, LocalDate birthdate, String department, String position, Float salary) {
        var employee = Employee.builder()
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .birthdate(birthdate)
                .department(department)
                .position(position)
                .salary(salary)
                .build();
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Employee.EmployeeId employeeId) {
        return employeeRepository.findById(employeeId);
    }
}
