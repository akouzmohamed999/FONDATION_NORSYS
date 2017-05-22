package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.RendezVous;
import fr.norsys.fondation.repositories.RendezVousRepository;
import fr.norsys.fondation.services.RendezVousService;

@Service
public class RendezVousServiceImpl implements RendezVousService {

	@Autowired
	RendezVousRepository rendezVousRepository;

	@Override
	public List<RendezVous> findAllRendezVous() {
		return this.rendezVousRepository.findAll();
	}

	@Override
	public RendezVous addRendezVous(RendezVous rendezVous) {
		return this.rendezVousRepository.save(rendezVous);
	}

	@Override
	public RendezVous updateRendezVous(RendezVous rendezVous) {
		return this.rendezVousRepository.saveAndFlush(rendezVous);
	}

	@Override
	public void deleteRendezVous(RendezVous rendezVous) {
		this.rendezVousRepository.delete(rendezVous);

	}

	@Override
	public RendezVous findRendezVousById(int idRendezVous) {
		return this.rendezVousRepository.findOneByIdRendezVous(idRendezVous);
	}

}
