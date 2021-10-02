package project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByProductCategory(String productCategory);
    List<Product> findProductByName(String name);
    List<Product> findProductByPrice(Double price);
    List<Product> findProductByStockQuantity(int quantity);

}