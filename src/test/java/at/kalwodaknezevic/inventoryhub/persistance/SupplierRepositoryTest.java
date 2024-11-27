package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SupplierRepositoryTest {
    private @Autowired SupplierRepository supplierRepository;
    private Supplier supplier;

    @BeforeEach
    void setUp() {
        PhoneNumber phoneNumber = new PhoneNumber(43, 1, "4567890", 0, PhoneType.MOBILE);
        Country austria = new Country("Austria", "AT", "AUT", 43);
        Address address = new Address("Teststraße", "1", "1234", austria, AddressType.SHIPPING);
        supplier = Supplier.builder()
                .firstname("John")
                .lastname("Doe")
                .birthdate(LocalDate.of(1990, 1, 1))
                .email(new Email("john.doe@spg.at"))
                .phoneNumber(phoneNumber)
                .addresses(address)
                .companyName("SPG")
                .build();
    }

    @Test
    void canSave() {
        assertThat(supplierRepository.saveAndFlush(supplier).getSupplierId()).isNotNull();
    }

    @Test
    void canFindBySupplierId() {
        supplierRepository.saveAndFlush(supplier);
        var foundSupplier = supplierRepository.findBySupplierId(supplier.getSupplierId());
        assertThat(foundSupplier).isNotEmpty();
        assertThat(foundSupplier.get().getSupplierId()).isEqualTo(supplier.getSupplierId());
    }
}