package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Composante;
import fr.norsys.fondation.repositories.ComposanteRepository;
import fr.norsys.fondation.repositories.ProjetRepository;
import fr.norsys.fondation.services.ComposanteService;

@Service
public class ComposanteServiceImpl implements ComposanteService {

	@Autowired
	ComposanteRepository ComposanteRepository;

	@Autowired
	ProjetRepository projetRepository;

	@Override
	public Composante findComposanteById(int idComposante) {
		return this.ComposanteRepository.findOneByIdComposante(idComposante);
	}

	@Override
	public List<Composante> findAllComposantes() {
		return this.ComposanteRepository.findAll();
	}

	@Override
	public List<Composante> findCompetitionsByIdProjet(int idProjet) {

		return this.ComposanteRepository.findByProjet(this.projetRepository.findOneByIdProjet(idProjet));
	}

}
