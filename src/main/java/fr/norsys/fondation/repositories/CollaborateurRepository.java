package fr.norsys.fondation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.entities.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	Collaborateur findOneByNom(String nom);

	Collaborateur findOneByIdCollaborateur(int idCollaborateur);

	Collaborateur findOneByEmail(String email);

	List<Collaborateur> findByActivites(Activite activite);
	
}
