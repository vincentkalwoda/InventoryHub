package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.domain.OrderItem;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class CreateOrderForm {
    @NotBlank
    @NotNull
    private Employee employee;

    @NotBlank
    @NotNull
    private LocalDate orderDate;

    @NotBlank
    @NotNull
    private LocalDate deliveryDate;

    @NotBlank
    @NotNull
    private String status;

    @NotBlank
    @NotNull
    private Supplier supplier;

    @NotBlank
    @NotNull
    private List<OrderItem> orderItems;
}
