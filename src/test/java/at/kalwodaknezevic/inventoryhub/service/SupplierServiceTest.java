package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.persistance.EmployeeRepository;
import at.kalwodaknezevic.inventoryhub.persistance.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SupplierServiceTest {
    private @Mock SupplierRepository supplierRepository;

    private SupplierService supplierService;

    @BeforeEach
    void setUp() {
        assumeThat(supplierRepository).isNotNull();
        supplierService = new SupplierService(supplierRepository);
    }

    @Test
    void can_create_supplier() {
        var address = FixturesFactory.spengergasse20(FixturesFactory.austria());
        var supplier = FixturesFactory.johnDoeSupplier(address);
        when(supplierRepository.save(supplier)).thenReturn(supplier);

        var createdSupplier = supplierService.createSupplier(supplier.getFirstname(), supplier.getLastname(), supplier.getEmail(), supplier.getPhoneNumber(), supplier.getBirthdate(), supplier.getCompanyName());
        assertThat(createdSupplier).isEqualTo(supplier);
    }
}