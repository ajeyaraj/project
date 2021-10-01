package project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
class Contact {
    private @Id @GeneratedValue Long id;
    private String name;
    private String phone;
    private String email;
    private String position;

    public Contact() {}

    Contact(String name, String phone, String email, String position){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Contact)){
            return false;
        }
        Contact customerContact = (Contact) o;
        return Objects.equals(this.id, customerContact.id) && Objects.equals(this.name, customerContact.name)
                && Objects.equals(this.phone, customerContact.phone) && Objects.equals(this.email, customerContact.email)
                && Objects.equals(this.position, customerContact.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.phone, this.email, this.position);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
