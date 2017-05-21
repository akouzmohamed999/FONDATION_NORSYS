package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.BilanProjet;
import fr.norsys.fondation.repositories.BilanProjetRepository;
import fr.norsys.fondation.repositories.ProjetRepository;
import fr.norsys.fondation.services.BilanProjetService;

@Service
public class BilanProjetServiceImpl implements BilanProjetService {

	@Autowired
	BilanProjetRepository bilanProjetRepository;

	@Autowired
	ProjetRepository projetRepository;

	@Override
	public BilanProjet addBilanProjet(BilanProjet bilanProjet) {
		return this.bilanProjetRepository.save(bilanProjet);
	}

	@Override
	public List<BilanProjet> findAllBilansByIdProjet(int idRapport) {
		return this.bilanProjetRepository.findByProjet(this.projetRepository.findOneByIdProjet(idRapport));
	}

	@Override
	public List<BilanProjet> findAllBilans() {
		return this.bilanProjetRepository.findAll();
	}

}
