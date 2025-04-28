package kevin.example.service;

import kevin.example.dto.NewProductRequest;
import kevin.example.dto.ProductInfo;
import kevin.example.dto.ProductList;
import kevin.example.dto.ProductUpdateRequest;
import kevin.example.entity.Product;
import kevin.example.exceptions.BadRequestException;
import kevin.example.mapper.ProductMapper;
import kevin.example.model.PageableInfo;
import kevin.example.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ResourceClosedException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {
    final ProductRepository productRepository;
    final ProductMapper productMapper;
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product createNewProduct(NewProductRequest productRequest) {
        Product productChecked = productRepository.findByCode(productRequest.getCode());
        if(Objects.nonNull(productChecked)) {
            log.info("There are existed product with code: " + productRequest.getCode());
            throw new BadRequestException("Existed product with same code");
        }
        ProductInfo productInfo = new ProductInfo();
        productInfo.setDescription("des of pro info");
        Product product = productMapper.productDTOToProduct(productRequest, productInfo);
        return productRepository.save(product);
    }

    public Product updateProduct(ProductUpdateRequest productUpdateRequest) {
        this.getProduct(productUpdateRequest.getId());
        return productRepository.save(productUpdateRequest.mapToEntity());
    }

    public Product getProduct(Long id) {
        Optional<Product> searchedProduct = productRepository.findById(id);
        if (searchedProduct.isEmpty()) throw new ResourceClosedException("Not found product with id " + id);
        return searchedProduct.get();
    }

    public void deleteProduct(Long id) {
        Optional<Product> searchedProduct = productRepository.findById(id);
        if (searchedProduct.isEmpty()) throw new ResourceClosedException("Not found product with id " + id);
        productRepository.deleteById(id);
    }

    public ProductList queryProductList(PageableInfo pageableInfo){

        return null;
    }
}
