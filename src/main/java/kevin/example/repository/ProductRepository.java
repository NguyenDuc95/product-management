package kevin.example.repository;

import kevin.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, CrudRepository<Product, Long> {
    Product findByCode(String code);
}
