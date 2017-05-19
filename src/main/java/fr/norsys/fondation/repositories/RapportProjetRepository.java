package fr.norsys.fondation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.entities.RapportProjet;

public interface RapportProjetRepository extends JpaRepository<RapportProjet, Integer> {

	List<RapportProjet> findByProjet(Projet findOneByIdProjet);

}
