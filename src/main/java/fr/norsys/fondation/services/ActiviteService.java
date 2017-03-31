package fr.norsys.fondation.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.entities.Projet;

@Service
public interface ActiviteService {

	List<Activite> findAllActivities();

	List<Activite> findActivitiesByDateActivite(Date dateDebutActivite);

	List<Activite> findActivitiesByEtat(String etat);

	List<Activite> findActivitiesByProjet(Projet projet);

	List<Activite> findActivitiesByCollaborateur(Collaborateur collaborateur);

}
