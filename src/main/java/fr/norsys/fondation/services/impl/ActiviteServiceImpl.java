package fr.norsys.fondation.services.impl;

import java.sql.Date;
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

	@Override
	public List<Activite> findActivitiesByDateActivite(Date dateDebutActivite) {
		return this.activiteRepository.findByDateActivite(dateDebutActivite);
	}

	@Override
	public List<Activite> findActivitiesByEtat(String etat) {
		return this.activiteRepository.findByEtat(etat);
	}

}
