package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.RapportProjet;

@Service
public interface RapportProjetService {

	RapportProjet addRapportProjet(RapportProjet rapportProjet);

	List<RapportProjet> findRapportByIdProjet(int idProjet);

	List<RapportProjet> findAllRapportProjets();

}
