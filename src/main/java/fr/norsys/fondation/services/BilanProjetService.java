package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.BilanProjet;

@Service
public interface BilanProjetService {

	BilanProjet addBilanProjet(BilanProjet bilanProjet);

	List<BilanProjet> findAllBilansByIdProjet(int idRapport);

	List<BilanProjet> findAllBilans();

}
