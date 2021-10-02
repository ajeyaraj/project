package project.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    //Contact methods
    //List all contacts
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id){
        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    public List<Contact> getContactByName(String name){
        return contactRepository.findContactByName(name);
    }

    public List<Contact> getContactByEmail(String name){
        return contactRepository.findContactByEmail(name);
    }

    public List<Contact> getContactByPhone(String phone){
        return contactRepository.findContactByPhone(phone);
    }

    public List<Contact> getContactByPosition(String position){
        return contactRepository.findContactByPosition(position);
    }

    //Create a new contact
    public Contact addNewContact(Contact contact){
        List<Contact> contactByEmail = contactRepository.findContactByEmail(contact.getEmail());
        if(!(contactByEmail.isEmpty())){
            throw new IllegalStateException("email taken");
        }
        return contactRepository.save(contact);
    }

    //update customer
    public Contact updateContact(Long id, Contact contactDetails) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        contact.setName(contactDetails.getName());
        contact.setPhone(contactDetails.getPhone());
        contact.setEmail(contactDetails.getEmail());
        contact.setPosition(contactDetails.getPosition());
        return contactRepository.save(contact);
    }

    //Delete a contact
    public void deleteContactById(Long id){
        contactRepository.deleteById(id);
    }
}
