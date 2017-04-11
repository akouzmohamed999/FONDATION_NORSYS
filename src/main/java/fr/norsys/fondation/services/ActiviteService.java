package fr.norsys.fondation.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Activite;

@Service
public interface ActiviteService {

	List<Activite> findAllActivities();

	List<Activite> findActivitiesByDateActivite(Date dateDebutActivite);

	List<Activite> findActivitiesByEtat(String etat);

	List<Activite> findActivitiesByCollaborateur(int idCollaborateur);

	Activite addActivite(Activite activite);

	List<Activite> findActivitiesByComposante(int idComposante);

	List<Activite> findActivitiesByAnimateurTerrain(int idCollaborateur);

	Activite findAcitiviteById(int idActivite);

	Activite updateActiviteEtat(Activite activite);

	void removeActivite(Activite activite3Composante1Projet1Annule);

}
