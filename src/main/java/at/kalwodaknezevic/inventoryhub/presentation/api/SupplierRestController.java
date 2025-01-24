package at.kalwodaknezevic.inventoryhub.presentation.api;

import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import at.kalwodaknezevic.inventoryhub.dtos.EmployeeDto;
import at.kalwodaknezevic.inventoryhub.dtos.OrderDto;
import at.kalwodaknezevic.inventoryhub.dtos.SupplierDto;
import at.kalwodaknezevic.inventoryhub.service.EmployeeService;
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

    @GetMapping("/{supplierId}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable Supplier.SupplierId supplierId) {
        return supplierService.getSupplier(supplierId)
                .map(SupplierDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}