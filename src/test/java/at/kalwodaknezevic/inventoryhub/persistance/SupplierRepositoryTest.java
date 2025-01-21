package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.TestcontainersConfiguration;
import at.kalwodaknezevic.inventoryhub.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class SupplierRepositoryTest {
    private @Autowired SupplierRepository supplierRepository;
    private Supplier supplier;

    @BeforeEach
    void setUp() {
        Country austria = FixturesFactory.austria();
        Address address = FixturesFactory.spengergasse20(austria);
        supplier = FixturesFactory.johnDoeSupplier(address);
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

    @Test
    void canFindByFirstnameAndLastname() {
        supplierRepository.saveAndFlush(supplier);
        var foundSuppliers = supplierRepository.findByFirstnameAndLastname(supplier.getFirstname(), supplier.getLastname());
        assertThat(foundSuppliers).isNotEmpty();
        assertThat(foundSuppliers).anyMatch(s -> s.getSupplierId().equals(supplier.getSupplierId()));
    }

    @Test
    void canFindByCompanyName() {
        supplierRepository.saveAndFlush(supplier);
        var foundSupplier = supplierRepository.findByCompanyName(supplier.getCompanyName());
        assertThat(foundSupplier).isNotEmpty();
        assertThat(foundSupplier).anyMatch(s -> s.getSupplierId().equals(supplier.getSupplierId()));
    }
}