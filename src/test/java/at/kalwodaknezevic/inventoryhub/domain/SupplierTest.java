package at.kalwodaknezevic.inventoryhub.domain;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.Assertions.assertThat;

class SupplierTest {
    @Test
    void testSupplierAssertions() {
        Address address = FixturesFactory.spengergasse20(FixturesFactory.austria());
        Supplier supplier = FixturesFactory.johnDoeSupplier(address);

        assertThat(supplier)
                .hasValidFirstname()
                .hasValidLastname()
                .hasValidEmail()
                .hasValidPhoneNumber()
                .hasValidAddress()
                .hasValidCompanyName();
    }
}
