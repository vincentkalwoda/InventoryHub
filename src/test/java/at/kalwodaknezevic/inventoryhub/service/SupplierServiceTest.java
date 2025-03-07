package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.FixturesFactory;
import at.kalwodaknezevic.inventoryhub.commands.SupplierCommands.CreateSupplierCommand;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import at.kalwodaknezevic.inventoryhub.persistance.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SupplierServiceTest {
    private @Mock SupplierRepository supplierRepository;

    private SupplierService supplierService;
    private Supplier supplier;
    private CreateSupplierCommand createSupplierCommand;

    @BeforeEach
    void setUp() {
        assumeThat(supplierRepository).isNotNull();
        supplierService = new SupplierService(supplierRepository);
        var address = FixturesFactory.spengergasse20(FixturesFactory.austria());
        supplier = FixturesFactory.johnDoeSupplier(address);
        createSupplierCommand = FixturesFactory.createSupplierCommand(supplier);
    }

    @Test
    void can_create_supplier() {
        when(supplierRepository.save(supplier)).thenReturn(supplier);

        var createdSupplier = supplierService.createSupplier(createSupplierCommand);
        assertThat(createdSupplier).isEqualTo(supplier);
    }

    @Test
    void can_get_all_suppliers() {
        var address = FixturesFactory.spengergasse20(FixturesFactory.austria());
        var supplier = FixturesFactory.johnDoeSupplier(address);
        when(supplierRepository.findAll()).thenReturn(List.of(supplier));

        var suppliers = supplierService.getAll();
        assertThat(suppliers).containsExactly(supplier);
    }

    @Test
    void can_get_supplier() {
        var address = FixturesFactory.spengergasse20(FixturesFactory.austria());
        var supplier = FixturesFactory.johnDoeSupplier(address);
        when(supplierRepository.findById(supplier.getSupplierId())).thenReturn(java.util.Optional.of(supplier));

        var foundSupplier = supplierService.getSupplier(supplier.getSupplierId());
        assertThat(foundSupplier).isPresent().contains(supplier);
    }
}