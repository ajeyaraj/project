package project.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import project.order.OrderEvent;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //project.product.Product methods
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> getProductByProductCategory(String categoryName) {
        return productRepository.findProductByProductCategory(categoryName);
    }

    public Product getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    public List<Product> getProductByPrice(Double price) {
        return productRepository.findProductByPrice(price);
    }

    public List<Product> getProductByStockQuantity(int quantity) {
        return productRepository.findProductByStockQuantity(quantity);
    }

    //Create product
    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    //update product
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(productDetails.getName());
        product.setProductCategory(productDetails.getProductCategory());
        product.setPrice(productDetails.getPrice());
        product.setStockQuantity(productDetails.getStockQuantity());
        return productRepository.save(product);
    }

    //Delete product
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    //Return unit price if enough quantity in stock
    public Double getUnitPrice(String productName, int quantity){
        Product product = productRepository.findProductByName(productName);
        int availableStock =  product.getStockQuantity();
        if(availableStock >= quantity) {
            return product.getPrice();
        }
        return null;
    }

    //update Stock Quantity of product ordered
    @EventListener
    public void updateStockQuantity(OrderEvent orderEvent){
        String productName = orderEvent.getProductName();
        int quantity = orderEvent.getQuantity();
        Product product = getProductByName(productName);
        int newStockQuantity = product.getStockQuantity() - quantity;
        product.setStockQuantity(newStockQuantity);
    }
}
