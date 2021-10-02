package project.customer;

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

    //Contact get methods
    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/contacts/id/{id}")
    public Contact getContactById(@PathVariable Long id){
        return contactService.getContactById(id);
    }

    @GetMapping("/contacts/name/{name}")
    public List<Contact> getContactByName(@PathVariable String name){
        return contactService.getContactByName(name);
    }

    @GetMapping("/contacts/phone/{phone}")
    public List<Contact> getContactByPhone(@PathVariable String phone){
        return contactService.getContactByPhone(phone);
    }

    @GetMapping("/contacts/email/{email}")
    public List<Contact> getContactByEmail(@PathVariable String email){
        return contactService.getContactByEmail(email);
    }

    @GetMapping("/contacts/position/{name}")
    public List<Contact> getContactByPosition(@PathVariable String name){
        return contactService.getContactByPosition(name);
    }

    //Create contact
    @PostMapping("/addContact")
    public Contact addNewContact(@RequestBody Contact newContact){
       return contactService.addNewContact(newContact);
    }

    //update contact
    @PutMapping("/contacts/{id}")
    public Contact updateContact(@PathVariable(value = "id") Long id, @RequestBody Contact contactDetails) throws ContactNotFoundException {
        return contactService.updateContact(id, contactDetails);
    }

    //delete contact
    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
    }
}
