package project;

public class ProductDetailNotFoundException extends RuntimeException{

    public ProductDetailNotFoundException(String message) {
        super(message);
    }

    ProductDetailNotFoundException(Long id) {
        super("Could not find product detail with id: " + id);
    }
}
