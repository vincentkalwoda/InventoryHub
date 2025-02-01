package at.kalwodaknezevic.inventoryhub.assertions;

import at.kalwodaknezevic.inventoryhub.domain.Employee;
import org.assertj.core.api.AbstractAssert;

public class EmployeeAssert extends AbstractAssert<EmployeeAssert, Employee> {
    public EmployeeAssert(Employee employee) {
        super(employee, EmployeeAssert.class);
    }

    public static EmployeeAssert assertThat(Employee actual) {
        return new EmployeeAssert(actual);
    }

    public EmployeeAssert hasValidFirstname() {
        isNotNull();
        if (actual.getName().firstname() == null || actual.getName().firstname().isEmpty()) {
            failWithMessage("Expected employee's first name to be not null and not empty but was <%s>", actual.getName().firstname());
        }
        return this;
    }

    public EmployeeAssert hasValidLastname() {
        isNotNull();
        if (actual.getName().lastname() == null || actual.getName().lastname().isEmpty()) {
            failWithMessage("Expected employee's last name to be not null and not empty but was <%s>", actual.getName().lastname());
        }
        return this;
    }

    public EmployeeAssert hasValidEmail() {
        isNotNull();
        if (actual.getEmail() == null || actual.getEmail().toString().isEmpty()) {
            failWithMessage("Expected employee's email to be not null and not empty but was <%s>", actual.getEmail());
        }
        return this;
    }

    public EmployeeAssert hasValidPhoneNumber() {
        isNotNull();
        if (actual.getPhoneNumber() == null || actual.getPhoneNumber().toString().isEmpty()) {
            failWithMessage("Expected employee's phone number to be not null and not empty but was <%s>", actual.getPhoneNumber());
        }
        return this;
    }

    public EmployeeAssert hasValidAddress() {
        isNotNull();
        if (actual.getAddress() == null || actual.getAddress().toString().isEmpty()) {
            failWithMessage("Expected employee's address to be not null but was <%s>", actual.getAddress());
        }
        return this;
    }

    public EmployeeAssert hasValidDepartment() {
        isNotNull();
        if (actual.getDepartment() == null || actual.getDepartment().isEmpty()) {
            failWithMessage("Expected employee's department to be not null and not empty but was <%s>", actual.getDepartment());
        }
        return this;
    }

    public EmployeeAssert hasValidPosition() {
        isNotNull();
        if (actual.getPosition() == null || actual.getPosition().isEmpty()) {
            failWithMessage("Expected employee's position to be not null and not empty but was <%s>", actual.getPosition());
        }
        return this;
    }

    public EmployeeAssert hasValidSalary() {
        isNotNull();
        if (actual.getSalary() <= 0) {
            failWithMessage("Expected employee's salary to be greater than 0 but was <%s>", actual.getSalary());
        }
        return this;
    }
}