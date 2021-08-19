/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.Contact;
import project.Customer;
import project.CustomerRepository;
import project.ContactRepository;


@RestController
class CustomerController {

  private final CustomerRepository customerRepository;
  private final ContactRepository contactRepository;

  CustomerController(CustomerRepository customerRepository, ContactRepository contactRepository) {
    this.customerRepository = customerRepository;
    this.contactRepository = contactRepository;
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/customers")
  List<Customer> all() {
    return customerRepository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/customers")
  Customer newCustomer(@RequestBody Customer newCustomer) {
    return customerRepository.save(newCustomer);
  }

  // Single item

  @GetMapping("/customers/{id}")
  Customer one(@PathVariable Long id) {
    return customerRepository.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException(id));
  }

  @PutMapping("/customers/{id}")
  Customer replaceEmployee(@RequestBody Customer newCustomer, @PathVariable Long id) {

    return customerRepository.findById(id)
            .map(customer -> {
              customer.setName(newCustomer.getName());
              customer.setGender(newCustomer.getGender());
              customer.setAge(newCustomer.getAge());
              return customerRepository.save(customer);
            })
            .orElseGet(() -> {
              newCustomer.setId(id);
              return customerRepository.save(newCustomer);
            });
  }

  @PutMapping("/customers/{id}/contact/{contactId}")
  Customer updateCustomerContact(@PathVariable Long id, @PathVariable Long contactId){
    Customer customer = customerRepository.findById(id).orElseThrow(RuntimeException::new);
    Contact contact = contactRepository.findById(contactId).orElseThrow(RuntimeException::new);
    customer.setContact(contact);
    return customerRepository.save(customer);
  }

  @DeleteMapping("/customers/{id}")
  void deleteCustomer(@PathVariable Long id) {
    customerRepository.deleteById(id);
  }
}
