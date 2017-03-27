package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
