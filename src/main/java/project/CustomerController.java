/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/id/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customers/companyName/{companyName}")
    public List<Customer> getCustomerByCompanyName(@PathVariable String companyName){
        return customerService.getCustomerByCompanyName(companyName);
    }

    @GetMapping("/customers/address/{address}")
    public List<Customer> getCustomerByAddress(@PathVariable String address){
        return customerService.getCustomerByAddress(address);
    }

    @GetMapping("/customers/country/{country}")
    public List<Customer> getCustomerByCountry(@PathVariable String country){
        return customerService.getCustomerByCountry(country);
    }

    @PostMapping("/addCustomer")
    public Customer createNewCustomer(@RequestBody Customer newCustomer) {
        return customerService.addNewCustomer(newCustomer);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") Long id, @RequestBody Customer customerDetails) throws CustomerNotFoundException {
        return customerService.updateCustomer(id, customerDetails);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }

    @GetMapping("/customerByOrder/{id}")
    public Optional<Customer> getCustomerByOrder(@PathVariable Order id) {
        return customerService.getCustomerByOrder(id);
    }
}
