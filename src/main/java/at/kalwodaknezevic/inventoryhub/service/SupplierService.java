package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.domain.*;
import at.kalwodaknezevic.inventoryhub.foundation.Base58;
import at.kalwodaknezevic.inventoryhub.persistance.SupplierRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))

@Service
@Transactional
public class SupplierService {
    private final SupplierRepository supplierRepository;

    @Transactional
    public Supplier createSupplier(Name name, Email email, PhoneNumber phoneNumber, LocalDate birthdate, String companyName) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("s_" + Base58.random(10));
        } while (supplierRepository.findByApiKey(apiKey).isPresent());

        var supplier = Supplier.builder()
                .apiKey(apiKey)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .birthdate(birthdate)
                .companyName(companyName)
                .build();
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplier(Supplier.SupplierId supplierId) {
        return supplierRepository.findById(supplierId);
    }
}
