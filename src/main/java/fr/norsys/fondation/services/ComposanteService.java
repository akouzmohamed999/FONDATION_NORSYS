package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Composante;

@Service
public interface ComposanteService {

	Composante findComposanteById(int idComposante);

	List<Composante> findAllComposantes();

	List<Composante> findCompetitionsByIdProjet(int idProjet);

	Composante addComposante(Composante composante);

	Composante updateComposante(Composante composante);

	List<Composante> findComposanteByThematique(int idThematique);

	void deleteComposante(Composante composante);

}
