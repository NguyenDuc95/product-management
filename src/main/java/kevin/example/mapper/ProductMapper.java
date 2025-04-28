package kevin.example.mapper;

import kevin.example.dto.NewProductRequest;
import kevin.example.dto.ProductInfo;
import kevin.example.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "code", target = "code", qualifiedByName = "addSuffix")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description", ignore = true)
    Product productDTOToProduct(NewProductRequest newProductRequest);

    @Mapping(source = "newProductRequest.code", target = "code", qualifiedByName = "addSuffix")
    @Mapping(expression = "java(this.getName(newProductRequest))", target = "name")
    @Mapping(expression = "java(productInfo == null ? null : productInfo.getDescription())", target = "description")
    Product productDTOToProduct(NewProductRequest newProductRequest, ProductInfo productInfo);


    default String getName(NewProductRequest newProductRequest){
        return Objects.isNull(newProductRequest) ? null : newProductRequest.getName();
    }
    @Named("addSuffix")
    default String addSuffix(String value) {
        if (Objects.isNull(value)) return value;
        return value + ThreadLocalRandom.current().nextInt(1, 1000);
    }

}
