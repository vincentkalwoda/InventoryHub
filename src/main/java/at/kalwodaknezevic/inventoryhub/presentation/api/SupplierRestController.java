package at.kalwodaknezevic.inventoryhub.presentation.api;

import at.kalwodaknezevic.inventoryhub.dtos.SupplierDto;
import at.kalwodaknezevic.inventoryhub.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping(ApiConstants.API+"/suppliers")
public class SupplierRestController {
    private final SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierDto>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAll()
                .stream()
                .map(SupplierDto::new)
                .toList());
    }

    @GetMapping("/{apiKey}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable String apiKey) {
        return supplierService.getSupplier(apiKey)
                .map(SupplierDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}