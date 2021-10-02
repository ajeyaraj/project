package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    //private final ContactRepository contactRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository, ContactRepository contactRepository) {
        this.customerRepository = customerRepository;
       // this.contactRepository = contactRepository;
    }

    //Customer methods
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public List<Customer> getCustomerByCompanyName(String companyName) {
        return customerRepository.findCustomerByCompanyName(companyName);
    }

    public List<Customer> getCustomerByAddress(String address) {
        return customerRepository.findCustomerByAddress(address);
    }

    public List<Customer> getCustomerByCountry(String country) {
       return customerRepository.findCustomerByCountry(country);
    }

    //Create customer
    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    //update customer
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customer.setCompanyName(customerDetails.getCompanyName());
        customer.setAddress(customerDetails.getAddress());
        customer.setCountry(customerDetails.getCountry());
        return customerRepository.save(customer);
    }

    //Delete customer
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    public String validCustomerId(Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return customer.getAddress();
    }
}
