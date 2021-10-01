package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Customer methods
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    //Create customer
    public void addNewCustomer(Customer customer) {
        customerRepository.save(customer);
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
}
