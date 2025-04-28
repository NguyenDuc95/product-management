package kevin.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kevin.example.entity.Product;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class ProductUpdateRequest {
    @Schema(name = "id", example = "1",description = "id of product", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id is required")
    private Long id;
    @Schema(name = "code", example = "PROD_A",description = "code of product", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String code;
    @Schema(name = "description", example = "description product A",description = "description of product", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String description;
    @Schema(name = "name", example = "name product A",description = "name of product", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String name;

    public Product mapToEntity() {
        Product product = new Product();
        product.setId(this.getId());
        product.setCode(this.getCode());
        product.setName(this.getName());
        product. setDescription(this.getDescription());
        return product;
    }
}
