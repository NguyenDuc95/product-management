package kevin.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import kevin.example.dto.NewProductRequest;
import kevin.example.dto.ProductInfo;
import kevin.example.dto.ProductList;
import kevin.example.dto.ProductUpdateRequest;
import kevin.example.entity.Product;
import kevin.example.model.PageableInfo;
import kevin.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@Tag(name = "Product APIs", description = "Danh sách các api liên quan tới CRUD product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Operation(
            summary = "api get product info",
            description = "api get product info by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successs"),
                    @ApiResponse(responseCode = "400", description = "bad requesst")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(
            @Parameter(name = "id", description = "id of product", required = true, example = "1")
            @PathVariable @NotNull(message = "id is required") Long id
    ) {
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @Operation(
            summary = "api update product info",
            description = "api update product info by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successs"),
                    @ApiResponse(responseCode = "400", description = "bad requesst")
            }
    )
    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public ResponseEntity<Product> updateProduct(
            @RequestBody @Valid ProductUpdateRequest productUpdateRequest
    ) {
        Product product = productService.updateProduct(productUpdateRequest);
        return ResponseEntity.ok(product);
    }


    @PostMapping("")
    @Operation(
            summary = "api create new product info",
            description = "api create new product info",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successs"),
                    @ApiResponse(responseCode = "400", description = "bad requesst")
            }
    )
    public ResponseEntity<Product> createNewProduct(
            @RequestBody @Valid NewProductRequest newProductRequest
    ) {
        Product product = productService.createNewProduct(newProductRequest);
        return ResponseEntity.ok(product);
    }

    @Operation(
            summary = "api delete product info",
            description = "api delete product info by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successs"),
                    @ApiResponse(responseCode = "400", description = "bad requesst")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable @Valid Long id
    ) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("success");
    }

    @GetMapping
    public ResponseEntity<ProductList> queryProduct(
            @RequestParam (defaultValue = "1", required = false) @Min(value = 1, message = "page is more than 1") Integer page,
            @RequestParam (defaultValue = "10", required = false) @Min(value = 0, message = "page is more than 1") Integer pageSize,
            @RequestParam (defaultValue = "name", required = false) String order,
            @RequestParam (defaultValue = "asc", required = false) String sort
    ){
        ProductList productList = productService.queryProductList(new PageableInfo(page, pageSize, sort, order));
        return ResponseEntity.ok().body(productList);
    }
}
