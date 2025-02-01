package at.kalwodaknezevic.inventoryhub.domain;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.Assertions.assertThat;

class EmployeeTest {
    @Test
    void testEmployeeAssertions() {
        Address address = FixturesFactory.spengergasse20(FixturesFactory.austria());
        Employee employee = FixturesFactory.johnDoeEmployee(address);

        assertThat(employee)
                .hasValidFirstname()
                .hasValidLastname()
                .hasValidEmail()
                .hasValidAddress()
                .hasValidPhoneNumber()
                .hasValidDepartment()
                .hasValidPosition()
                .hasValidSalary();
    }
}
