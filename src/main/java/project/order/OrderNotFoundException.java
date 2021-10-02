package project.order;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {
        super(message);
    }

    OrderNotFoundException(Long id) {
        super("Could not find order with Id: " + id);
    }
}