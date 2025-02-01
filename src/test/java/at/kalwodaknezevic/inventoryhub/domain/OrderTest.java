package at.kalwodaknezevic.inventoryhub.domain;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import org.junit.jupiter.api.Test;

import static at.kalwodaknezevic.inventoryhub.assertions.Assertions.assertThat;

class OrderTest {
    @Test
    void testOrderAssertions() {
        Address address = FixturesFactory.spengergasse20(FixturesFactory.austria());
        Employee employee = FixturesFactory.johnDoeEmployee(address);
        Supplier supplier = FixturesFactory.johnDoeSupplier(address);
        Article article = FixturesFactory.article();
        Order order = FixturesFactory.order(supplier, employee, article);

        assertThat(order)
                .hasValidOrderDate()
                .hasValidOrderStatus()
                .hasValidEmployee()
                .hasValidSupplier()
                .hasValidOrderItems();
    }
}
