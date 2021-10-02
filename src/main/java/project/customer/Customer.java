/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.customer;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
  private String companyName;
  private String address;
  private String country;

  public Customer() {}

  public Customer(String companyName, String address, String country) {
    this.companyName = companyName;
    this.address = address;
    this.country = country;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Customer))
      return false;
    Customer customer = (Customer) o;
    return Objects.equals(this.id, customer.id) && Objects.equals(this.companyName, customer.companyName)
        && Objects.equals(this.address, customer.address) && Objects.equals(this.country, customer.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.companyName, this.address, this.country);
  }

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", companyName='" + companyName + '\'' +
            ", address='" + address + '\'' +
            ", country='" + country + '\'' +
            '}';
  }
}