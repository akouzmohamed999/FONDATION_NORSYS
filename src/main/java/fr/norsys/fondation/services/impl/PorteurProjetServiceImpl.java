package fr.norsys.fondation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.PorteurProjet;
import fr.norsys.fondation.repositories.PorteurProjetRepository;
import fr.norsys.fondation.services.PorteurProjetService;

@Service
public class PorteurProjetServiceImpl implements PorteurProjetService {

	@Autowired
	PorteurProjetRepository porteurProjetRepository;

	@Override
	public PorteurProjet addPorteurProjet(PorteurProjet porteurProjet) {
		return this.porteurProjetRepository.save(porteurProjet);
	}

	@Override
	public PorteurProjet findPorteurProjetById(int idPorteurProjet) {
		return this.porteurProjetRepository.findOneByIdPorteur(idPorteurProjet);
	}

}
