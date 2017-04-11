package fr.norsys.fondation.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.entities.Responsable;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {

	List<Projet> findByIntitule(String intitule);

	List<Projet> findByResponsable(Responsable responsable);

	List<Projet> findByDateDebut(Date dateDebut);

	List<Projet> findByDateFin(Date dateFin);

	Projet findOneByIdProjet(int idProjet);

}
