package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.domain.Email;
import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import at.kalwodaknezevic.inventoryhub.domain.PhoneNumber;
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
    public Employee createEmployee(Name firstname, Name lastname, Email email, PhoneNumber phoneNumber, LocalDate birthdate, String department, String position, Float salary) {
        var employee = Employee.builder()
                .firstname(firstname)
                .lastname(lastname)
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

    public Optional<Employee> getEmployee(Long employeeId) {
        return employeeRepository.findById(new Employee.EmployeeId(employeeId));
    }
}
