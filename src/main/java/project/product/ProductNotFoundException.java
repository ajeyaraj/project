package project.product;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }

    ProductNotFoundException(Long id) {
        super("Could not find product with id: " + id);
    }
}

