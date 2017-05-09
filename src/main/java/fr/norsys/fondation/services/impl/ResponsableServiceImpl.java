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

}
