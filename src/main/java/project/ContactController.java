package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/contacts/{id}")
    public Contact getContactById(@PathVariable Long id){
        return contactService.getContactById(id);
    }

    @PostMapping("/addContact")
    public void addNewContact(@RequestBody Contact newContact){
        contactService.addNewContact(newContact);
    }

    @PutMapping("/contacts/{id}")
    public Contact updateContact(@PathVariable(value = "id") Long id, @RequestBody Contact contactDetails) throws ContactNotFoundException {
        return contactService.updateContact(id, contactDetails);
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
    }
}
