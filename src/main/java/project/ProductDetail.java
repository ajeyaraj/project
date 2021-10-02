/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author lukey
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
class ProductDetail {

    private @Id @GeneratedValue Long name;
    private String description;
    private String comment;

    public ProductDetail() {}

    ProductDetail(String productCategory, String price){
        this.description = productCategory;
        this.comment = price;
    }

    public Long getId() {
        return name;
    }

    public void setId(Long name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Contact)){
            return false;
        }
        ProductDetail customerContact = (ProductDetail) o;
        return Objects.equals(this.name, customerContact.name) && Objects.equals(this.description, customerContact.description)
                && Objects.equals(this.comment, customerContact.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.description, this.comment);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name=" + name +
                ", productCategory='" + description + '\'' +
                ", comment ='" + comment+ '\'' +
                '}';
    }
}
