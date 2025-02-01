package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.TestcontainersConfiguration;
import at.kalwodaknezevic.inventoryhub.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class OrderRepositoryTest {
    private @Autowired OrderRepository orderRepository;
    private @Autowired SupplierRepository supplierRepository;
    private @Autowired EmployeeRepository employeeRepository;
    private @Autowired ArticleRepository articleRepository;
    private Order order;

    @BeforeEach
    void setUp() {
        Country austria = FixturesFactory.austria();
        Address address = FixturesFactory.spengergasse20(austria);
        Supplier supplier = FixturesFactory.johnDoeSupplier(address);
        supplierRepository.saveAndFlush(supplier);
        Employee employee = FixturesFactory.johnDoeEmployee(address);
        employeeRepository.saveAndFlush(employee);
        Article article = FixturesFactory.article();
        articleRepository.saveAndFlush(article);

        order = FixturesFactory.order(supplier, employee, article);
    }

    @Test
    void canSave() {
        assertThat(orderRepository.saveAndFlush(order).getOrderId()).isNotNull();
    }

    @Test
    void canFindByOrderId() {
        orderRepository.saveAndFlush(order);
        var foundOrder = orderRepository.findOrderByOrderId(order.getOrderId());
        assertThat(foundOrder).isNotEmpty();
        assertThat(foundOrder.get().getOrderId()).isEqualTo(order.getOrderId());
    }
}