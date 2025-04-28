package kevin.example.dto;

import kevin.example.entity.Product;
import kevin.example.mapper.ProductInfoMapper;
import kevin.example.mapper.ProductMapper;
import kevin.example.service.ProductService;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class ProductList {
    private Integer totalItem;
    private List<ProductInfo> productInfoList;

    public ProductList(){}
}
