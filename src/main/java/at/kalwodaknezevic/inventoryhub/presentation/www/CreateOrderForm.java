package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.domain.Employee;
import at.kalwodaknezevic.inventoryhub.domain.Supplier;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CreateOrderForm {
    @NotNull
    private Employee employee;

    @NotNull
    private LocalDate orderDate;

    @NotNull
    private LocalDate deliveryDate;

    @NotNull
    private Supplier supplier;

    @NotNull
    private List<OrderItemForm> orderItems = new ArrayList<>();
}