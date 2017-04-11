package fr.norsys.fondation.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.entities.Composante;

public interface ActiviteRepository extends JpaRepository<Activite, Integer> {

	List<Activite> findByDateActivite(Date dateDebutActivite);

	List<Activite> findByEtat(String etat);

	List<Activite> findByCollaborateurs(Collaborateur collaborateur);

	List<Activite> findByComposante(Composante composante);

}
