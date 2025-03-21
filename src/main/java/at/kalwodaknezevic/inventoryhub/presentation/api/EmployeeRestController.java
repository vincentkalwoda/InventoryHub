package at.kalwodaknezevic.inventoryhub.presentation.api;

import at.kalwodaknezevic.inventoryhub.dtos.EmployeeDto;
import at.kalwodaknezevic.inventoryhub.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping(ApiConstants.API+"/employees")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAll()
                .stream()
                .map(EmployeeDto::new)
                .toList());
    }

    @GetMapping("/{apiKey}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String apiKey) {
        return employeeService.getEmployee(apiKey)
                .map(EmployeeDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
