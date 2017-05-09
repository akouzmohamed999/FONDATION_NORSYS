package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Composante;
import fr.norsys.fondation.repositories.ComposanteRepository;
import fr.norsys.fondation.repositories.ProjetRepository;
import fr.norsys.fondation.repositories.ThematiqueRepository;
import fr.norsys.fondation.services.ComposanteService;

@Service
public class ComposanteServiceImpl implements ComposanteService {

	@Autowired
	ComposanteRepository ComposanteRepository;

	@Autowired
	ProjetRepository projetRepository;

	@Autowired
	ThematiqueRepository thematiqueRepository;

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

	@Override
	public Composante addComposante(Composante composante) {
		return this.ComposanteRepository.save(composante);
	}

	@Override
	public Composante updateComposante(Composante composante) {
		return this.ComposanteRepository.saveAndFlush(composante);
	}

	@Override
	public List<Composante> findComposanteByThematique(int idThematique) {
		return this.ComposanteRepository.findByThematique(this.thematiqueRepository.findByIdThematique(idThematique));
	}

	@Override
	public void deleteComposante(Composante composante) {
		this.ComposanteRepository.delete(composante);
	}

}
