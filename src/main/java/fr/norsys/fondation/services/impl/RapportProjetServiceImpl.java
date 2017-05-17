package fr.norsys.fondation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.RapportProjet;
import fr.norsys.fondation.repositories.RapportProjetRepository;
import fr.norsys.fondation.services.RapportProjetService;

@Service
public class RapportProjetServiceImpl implements RapportProjetService {

	@Autowired
	RapportProjetRepository rapportProjetRespository;

	@Override
	public RapportProjet addRapportProjet(RapportProjet rapportProjet) {
		return this.rapportProjetRespository.save(rapportProjet);
	}

}
