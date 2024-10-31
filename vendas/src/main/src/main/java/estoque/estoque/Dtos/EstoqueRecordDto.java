package estoque.estoque.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EstoqueRecordDto(@NotBlank String productName, @NotNull Integer quantity) {
}
