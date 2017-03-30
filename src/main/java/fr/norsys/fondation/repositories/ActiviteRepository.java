package fr.norsys.fondation.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Integer> {

	List<Activite> findByDateActivite(Date dateDebutActivite);

	List<Activite> findByEtat(String etat);

}
