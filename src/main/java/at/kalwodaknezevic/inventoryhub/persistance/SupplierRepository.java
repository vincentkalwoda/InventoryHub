package at.kalwodaknezevic.inventoryhub.persistance;

import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Supplier.SupplierId> {
    Optional<Supplier> findBySupplierId(Supplier.SupplierId supplierId);
    List<Supplier> findByName(Name name);
    List<Supplier> findByCompanyName(String companyName);

    Optional<Supplier> findByApiKey(ApiKey apiKey);
}
