package project.customer;

public class ContactNotFoundException extends RuntimeException {

    ContactNotFoundException(Long id) {
        super("Could not find contact " + id);
    }
}
