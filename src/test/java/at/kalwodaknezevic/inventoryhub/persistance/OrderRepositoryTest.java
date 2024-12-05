package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OrderRepositoryTest {
    private @Autowired OrderRepository orderRepository;
    private @Autowired SupplierRepository supplierRepository;
    private Order order;

    @BeforeEach
    void setUp() {
        PhoneNumber phoneNumber = new PhoneNumber(43, 1, "4567890", 0, PhoneType.MOBILE);
        Country austria = new Country("Austria", "AT", "AUT", 43);
        Address address = new Address("Teststraße", "1", "1234", austria, AddressType.SHIPPING);
        Supplier supplier = Supplier.builder()
                .firstname("John")
                .lastname("Doe")
                .birthdate(LocalDate.of(1990, 1, 1))
                .email(new Email("john.doe@spg.at"))
                .phoneNumber(phoneNumber)
                .addresses(address)
                .companyName("SPG")
                .build();
        supplierRepository.saveAndFlush(supplier);

        order = Order.builder()
                .orderId(new Order.OrderId(1L))
                .orderDate(LocalDate.now())
                .deliveryDate(LocalDate.now().plusDays(5))
                .orderStatus(OrderStatus.PENDING)
                .supplier(supplier)
                .build();
    }

    @Test
    void canSave() {
        assertThat(orderRepository.saveAndFlush(order).getOrderId()).isNotNull();
    }

    @Test
    void canFindByOrderId() {
        orderRepository.saveAndFlush(order);
        var foundOrder = orderRepository.findByOrderId(order.getOrderId());
        assertThat(foundOrder).isNotEmpty();
        assertThat(foundOrder.get().getOrderId()).isEqualTo(order.getOrderId());
    }
}