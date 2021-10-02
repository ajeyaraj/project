package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/id/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/products/categoryName/{categoryName}")
    public List<Product> getCustomerByCompanyName(@PathVariable String categoryName){
        return productService.getProductByProductCategory(categoryName);
    }

    @GetMapping("/products/productName/{productName}")
    public List<Product> getProductByName(@PathVariable String productName){
        return productService.getProductByName(productName);
    }

    @GetMapping("/products/price/{price}")
    public List<Product> getProductByPrice(@PathVariable Double price){
        return productService.getProductByPrice(price);
    }

    @GetMapping("/products/quantity/{quantity}")
    public List<Product> getProductByStockQuantity(@PathVariable int quantity){
        return productService.getProductByStockQuantity(quantity);
    }

    @PostMapping("/addProduct")
    public Product createNewProduct(@RequestBody Product newProduct) {
        return productService.addNewProduct(newProduct);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable(value = "id") Long id, @RequestBody Product productDetails) throws ProductNotFoundException {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}
