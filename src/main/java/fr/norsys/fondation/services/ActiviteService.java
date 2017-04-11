package fr.norsys.fondation.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.entities.Composante;

@Service
public interface ActiviteService {

	List<Activite> findAllActivities();

	List<Activite> findActivitiesByDateActivite(Date dateDebutActivite);

	List<Activite> findActivitiesByEtat(String etat);

	List<Activite> findActivitiesByCollaborateur(Collaborateur collaborateur);

	Activite addActivite(Activite activite);

	List<Activite> findActivitiesByComposante(Composante composante);

	List<Activite> findActivitiesByAnimateurTerrain(Collaborateur collaborateur);

}
