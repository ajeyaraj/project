/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;

import java.util.Objects;

import javax.persistence.*;

@Entity
class Customer {

  private @Id @GeneratedValue Long id;
  private String name;
  private String gender;
  private int age;

  @OneToOne
  @JoinColumn(name = "contact_id")
  private Contact contact;

  public Customer() {}

  Customer(String name,String gender, int age) {
    this.name = name;
    this.gender = gender;
    this.age = age;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
  public String getGender() {
    return this.gender;
  }
  public int getAge() {
    return this.age;
  }
  public Contact getContact(){return contact;}

  public void setId(Long id) {
    this.id = id;
  }

   public void setGender(String gender) {
    this.gender = gender;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setContact(Contact contact){this.contact = contact;}

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Customer))
      return false;
    Customer customer = (Customer) o;
    return Objects.equals(this.id, customer.id) && Objects.equals(this.name, customer.name)
        && Objects.equals(this.age, customer.age) && Objects.equals(this.gender, customer.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.gender, this.age);
  }

  @Override
  public String toString() {
    return "Customer{" + "id=" + this.id +", gender='"+this.gender +", name='" + this.name + '\'' + ", age='" + this.age + '\'' + '}';
  }
}