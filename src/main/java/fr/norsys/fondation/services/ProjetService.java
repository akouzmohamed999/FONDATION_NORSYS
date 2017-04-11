package fr.norsys.fondation.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Projet;

@Service
public interface ProjetService {

	List<Projet> findAllProjets();

	List<Projet> findProjetsByIntitule(String intitule);

	List<Projet> findProjetsByResponsable(int idResponsable);

	List<Projet> findProjetsByDateDebut(Date date);

	List<Projet> findProjetsByDateFin(Date testDateFin);

	Projet addProjet(Projet projet);

	Projet updateProjet(Projet projet);

	Projet findProjetById(int idProjet);

}
