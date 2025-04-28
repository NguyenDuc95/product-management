package kevin.example.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import kevin.example.entity.Product;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
public class NewProductRequest {
    @NotNull(message = "code is required")
    @NotEmpty(message = "code is not empty")
    @Schema(name = "code", description = "code of product", example = "PROA")
    private String code;

    @NotNull(message = "name is required")
    @NotEmpty(message = "name is not empty")
    @Schema(name = "name", description = "name of product", example = "Product PROA")
    private String name;

    @Schema(name = "description", description = "description of product", example = "Description product PROA")
    private String description;

    public Product mapToEntity() {
        Product product = new Product();
        product.setCode(this.getCode());
        product.setName(this.getName());
        product.setDescription(this.getDescription());
        return product;
    }
}
