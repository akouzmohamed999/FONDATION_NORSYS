package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Responsable;
import fr.norsys.fondation.repositories.ResponsableRepository;
import fr.norsys.fondation.services.ResponsableService;

@Service
public class ResponsableServiceImpl implements ResponsableService {

	@Autowired
	ResponsableRepository responsableRepository;

	@Override
	public List<Responsable> findAllResponsables() {
		return this.responsableRepository.findAll();
	}

	@Override
	public Responsable findResponsableById(int idResponsable) {
		return this.responsableRepository.findOneByIdCollaborateur(idResponsable);
	}

	@Override
	public Responsable addResponsable(Responsable responsable) {
		return this.responsableRepository.save(responsable);
	}

	@Override
	public Responsable updateResponsable(Responsable responsable) {
		return this.responsableRepository.saveAndFlush(responsable);
	}

	@Override
	public void deleteResponsable(Responsable responsable) {
		this.responsableRepository.delete(responsable);	
	}

}
