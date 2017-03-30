package fr.norsys.fondation.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.entities.Responsable;

@Service
public interface ProjetService {

	List<Projet> findAllProjets();

	List<Projet> findProjetsByIntitule(String intitule);

	List<Projet> findProjetsByCategorie(String categorie);

	List<Projet> findProjetsByResponsable(Responsable responsable);

	List<Projet> findProjetsByDateDebut(Date date);

	List<Projet> findProjetsByDateFin(Date testDateFin);

	Projet addProjet(Projet projet);

}
