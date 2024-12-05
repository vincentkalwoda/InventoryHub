package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Employee.EmployeeId> {
    Optional<Employee> findByEmployeeId(Employee.EmployeeId employeeId);
    Optional<Employee> findByFirstnameAndLastname(String firstname, String lastname);
}
