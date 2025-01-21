package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.Name;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Supplier.SupplierId> {
    Optional<Supplier> findBySupplierId(Supplier.SupplierId supplierId);
    List<Supplier> findByFirstnameAndLastname(Name firstname, Name lastname);
    List<Supplier> findByCompanyName(String companyName);
}
