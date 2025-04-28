package kevin.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductList {
    private Integer totalItem;
    private List<ProductInfo> productInfoList;
}
