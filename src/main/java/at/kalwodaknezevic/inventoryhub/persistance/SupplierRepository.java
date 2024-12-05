package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Supplier.SupplierId> {
    Optional<Supplier> findBySupplierId(Supplier.SupplierId supplierId);
    Optional<Supplier> findByFirstnameAndLastname(String firstname, String lastname);
    Optional<Supplier> findByCompanyName(String companyName);
}
