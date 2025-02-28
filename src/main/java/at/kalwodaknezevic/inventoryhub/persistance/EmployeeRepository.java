package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Email;
import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Employee.EmployeeId> {
    Optional<Employee> findByEmployeeId(Employee.EmployeeId employeeId);

    List<Employee> findByName(Name name);

    Optional<Employee> findByEmail(Email email);

    Optional<Employee> findByApiKey(ApiKey apiKey);

}