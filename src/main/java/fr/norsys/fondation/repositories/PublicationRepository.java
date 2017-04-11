package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {

}
