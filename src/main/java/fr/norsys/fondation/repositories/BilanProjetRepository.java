package fr.norsys.fondation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.BilanProjet;
import fr.norsys.fondation.entities.Projet;

public interface BilanProjetRepository extends JpaRepository<BilanProjet, Integer> {

	List<BilanProjet> findByProjet(Projet projet);

}
