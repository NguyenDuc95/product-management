package kevin.example.mapper;

import kevin.example.dto.ProductInfo;
import kevin.example.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductInfoMapper {

    ProductInfo productToProductInfo(Product product);
}
