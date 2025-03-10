package at.kalwodaknezevic.inventoryhub.presentation.www;

import at.kalwodaknezevic.inventoryhub.domain.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateArticleForm {
    @NotBlank
    @NotNull
    private String name;

    private String description;

    @NotNull
    private Category category;

    @NotNull
    private float price;
}
