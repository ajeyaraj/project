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
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(CustomerRepository repository1, ContactRepository repository2) {

    return args -> {
      log.info("Preloading " + repository1.save(new Customer("Jill Jones", "Female" ,18)));
      log.info("Preloading " + repository1.save(new Customer("Jack Jones", "Male" ,28)));
      log.info("Preloading " + repository2.save(new Contact("Sowmiya Ashokkumar", "0424300789" , "jsowmiya34@gmail.com", "General Manager")));
      log.info("Preloading " + repository2.save(new Contact("Ashokkumar Jeyaraj", "0424450789" , "jashok45@gmail.com", "Senior Software Engineer")));

    };
  }

}