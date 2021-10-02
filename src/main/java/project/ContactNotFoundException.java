package project;

public class ContactNotFoundException extends RuntimeException {

    ContactNotFoundException(Long id) {
        super("Could not find contact " + id);
    }
}
