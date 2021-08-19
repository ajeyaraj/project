package project;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import project.Contact;
import project.ContactRepository;

@RestController
class ContactController {
    private final ContactRepository repository;

    ContactController(ContactRepository repository) {
        this.repository = repository;
    }
    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/contacts")
    List<Contact> all() {
        return repository.findAll();
    }

    // end::get-aggregate-root[]
    @PostMapping("/addContact")
    Contact newContact(@RequestBody Contact newContact) {
        return repository.save(newContact);
    }

    // Single item
    @GetMapping("/contact/{id}")
    Contact one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/contact/{id}")
    Contact replaceEmployee(@RequestBody Contact newContact, @PathVariable Long id) {
        return repository.findById(id)
                .map(contact -> {
                    contact.setName(newContact.getName());
                    contact.setPhone(newContact.getPhone());
                    contact.setEmail(newContact.getEmail());
                    contact.setPosition(newContact.getPosition());
                    return repository.save(contact);
                })
                .orElseGet(() -> {
                    newContact.setId(id);
                    return repository.save(newContact);
                });
    }

    @DeleteMapping("/contact/{id}")
    void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
