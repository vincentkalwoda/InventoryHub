package at.kalwodaknezevic.inventoryhub.service;

import at.kalwodaknezevic.inventoryhub.commands.SupplierCommands.CreateSupplierCommand;
import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import at.kalwodaknezevic.inventoryhub.domain.Email;
import at.kalwodaknezevic.inventoryhub.domain.Name;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import at.kalwodaknezevic.inventoryhub.foundation.Base58;
import at.kalwodaknezevic.inventoryhub.persistance.SupplierRepository;
import at.kalwodaknezevic.inventoryhub.persistance.converter.PhoneNumberConverter;
import at.kalwodaknezevic.inventoryhub.presentation.www.CreateSupplierForm;
import at.kalwodaknezevic.inventoryhub.presentation.www.EditSupplierForm;
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

    public Supplier createSupplier(CreateSupplierForm form) {
        ApiKey apiKey;
        do {
            apiKey = new ApiKey("s_" + Base58.random(16));
        } while (supplierRepository.findByApiKey(apiKey).isPresent());

        var supplier = Supplier.builder()
                .apiKey(apiKey)
                .name(new Name(form.getFirstName(), form.getLastName()))
                .email(new Email(form.getEmail()))
                .phoneNumber(new PhoneNumberConverter().convertToEntityAttribute(form.getPhoneNumber()))
                .birthdate(LocalDate.parse(form.getBirthdate()))
                .companyName(form.getCompanyName())
                .build();

        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Supplier supplier) {
        Supplier supplierToUpdate = supplierRepository.findByApiKey(supplier.getApiKey()).get();
        supplierToUpdate.setName(supplier.getName());
        supplierToUpdate.setEmail(supplier.getEmail());
        supplierToUpdate.setPhoneNumber(supplier.getPhoneNumber());
        supplierToUpdate.setBirthdate(supplier.getBirthdate());
        supplierToUpdate.setCompanyName(supplier.getCompanyName());
        return supplierRepository.save(supplierToUpdate);
    }

    public Supplier updateSupplier(EditSupplierForm form) {
        Supplier supplierToUpdate = supplierRepository.findByApiKey(form.getApiKey()).get();
        supplierToUpdate.setName(new Name(form.getFirstName(), form.getLastName()));
        supplierToUpdate.setEmail(new Email(form.getEmail()));
        supplierToUpdate.setPhoneNumber(new PhoneNumberConverter().convertToEntityAttribute(form.getPhoneNumber()));
        supplierToUpdate.setBirthdate(LocalDate.parse(form.getBirthdate()));
        supplierToUpdate.setCompanyName(form.getCompanyName());
        return supplierRepository.save(supplierToUpdate);
    }

    public void deleteSupplier(String apiKey) {
        Supplier supplier = supplierRepository.findByApiKey(new ApiKey(apiKey)).get();
        supplierRepository.delete(supplier);
    }

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplier(String apiKey) {
        return supplierRepository.findByApiKey(new ApiKey(apiKey));
    }
}
