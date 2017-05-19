package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.RapportProjet;
import fr.norsys.fondation.repositories.ProjetRepository;
import fr.norsys.fondation.repositories.RapportProjetRepository;
import fr.norsys.fondation.services.RapportProjetService;

@Service
public class RapportProjetServiceImpl implements RapportProjetService {

	@Autowired
	RapportProjetRepository rapportProjetRespository;

	@Autowired
	ProjetRepository projetRepository;

	@Override
	public RapportProjet addRapportProjet(RapportProjet rapportProjet) {
		return this.rapportProjetRespository.save(rapportProjet);
	}

	@Override
	public List<RapportProjet> findRapportByIdProjet(int idProjet) {

		return this.rapportProjetRespository.findByProjet(this.projetRepository.findOneByIdProjet(idProjet));
	}

	@Override
	public List<RapportProjet> findAllRapportProjets() {
		return this.rapportProjetRespository.findAll();
	}

}
