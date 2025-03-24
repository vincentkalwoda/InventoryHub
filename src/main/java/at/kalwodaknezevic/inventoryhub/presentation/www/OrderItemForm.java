package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.domain.ApiKey;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemForm {
    @NotNull
    private ApiKey apiKey;

    @Min(1)
    @NotNull
    private Integer quantity;
}