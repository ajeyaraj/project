/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository, ContactRepository contactRepository, ProductRepository productRepository, ProductDetailRepository productDetailRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + customerRepository.save(new Customer("Kmart", "Macquarie centre", "Australia")));
            log.info("Preloading " + customerRepository.save(new Customer("Woolworths", "Ryde shopping mall", "Australia")));
            log.info("Preloading " + contactRepository.save(new Contact("Sowmiya Ashokkumar", "0424300789", "jsowmiya34@gmail.com", "General Manager")));
            log.info("Preloading " + contactRepository.save(new Contact("Ashokkumar Jeyaraj", "0424450789", "jashok45@gmail.com", "Senior Software Engineer")));
            log.info("Preloading " + productRepository.save(new Product("Furniture", "Single King size mattress", 100.00, 5)));
            log.info("Preloading " + productRepository.save(new Product("Furniture", "Wooden Bed side table", 45.00, 10)));
            log.info("Preloading " + productRepository.save(new Product("Garden supplies", "Lawn mower", 250.00, 5)));
            log.info("Preloading " + productDetailRepository.save(new ProductDetail("Good looking furniture", "Nice one, how much is it")));
            log.info("Preloading " + productDetailRepository.save(new ProductDetail("Multipurpose table in good condition", "Is it still available")));
            log.info("Preloading " + orderRepository.save(new Order(1L, "Lawn mower", 2)));
        };
    }
}
