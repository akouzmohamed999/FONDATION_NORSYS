package fr.norsys.fondation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {

	List<Publication> findByVisible(boolean visibilite);

	Publication findOneByIdPublication(int idPublication);

	Publication findOneByTitre(String titre);

}
