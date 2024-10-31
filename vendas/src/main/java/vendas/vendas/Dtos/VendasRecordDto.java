package vendas.vendas.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VendasRecordDto(@NotBlank String productName, @NotBlank String productId, @NotNull Integer quantity) {
}
