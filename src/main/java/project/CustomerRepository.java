/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByCompanyName(String companyName);
    List<Customer> findCustomerByAddress(String address);
    List<Customer> findCustomerByCountry(String country);
}
