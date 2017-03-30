package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.repositories.ActiviteRepository;
import fr.norsys.fondation.services.ActiviteService;

@Service
public class ActiviteServiceImpl implements ActiviteService {

	@Autowired
	ActiviteRepository activiteRepository;

	@Override
	public List<Activite> findAllActivities() {
		return this.activiteRepository.findAll();
	}

}
