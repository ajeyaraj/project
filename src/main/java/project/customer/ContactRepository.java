package project.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findContactByName(String name);
    List<Contact> findContactByPhone(String phone);
    List<Contact> findContactByEmail(String email);
    List<Contact> findContactByPosition(String position);
}
