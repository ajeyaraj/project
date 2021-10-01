package project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> findContactByName(String name);
    Optional<Contact> findContactByPhone(String phone);
    Optional<Contact> findContactByEmail(String email);
    Optional<Contact> findContactByPosition(String position);
}
