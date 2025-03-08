package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.commands.SupplierCommands.CreateSupplierCommand;
import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import at.kalwodaknezevic.inventoryhub.foundation.Base58;
import at.kalwodaknezevic.inventoryhub.persistance.SupplierRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))

@Service
@Transactional
public class SupplierService {
    private final SupplierRepository supplierRepository;

    @Transactional
    public Supplier createSupplier(CreateSupplierCommand command) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("s_" + Base58.random(16));
        } while (supplierRepository.findByApiKey(apiKey).isPresent());

        var supplier = Supplier.builder()
                .apiKey(apiKey)
                .name(command.name())
                .email(command.email())
                .phoneNumber(command.phoneNumber())
                .birthdate(command.birthdate())
                .companyName(command.companyName())
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
