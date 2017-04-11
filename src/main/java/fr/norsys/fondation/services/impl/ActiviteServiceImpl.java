package fr.norsys.fondation.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.repositories.ActiviteRepository;
import fr.norsys.fondation.repositories.CollaborateurRepository;
import fr.norsys.fondation.repositories.ComposanteRepository;
import fr.norsys.fondation.services.ActiviteService;

@Service
public class ActiviteServiceImpl implements ActiviteService {

	@Autowired
	private ActiviteRepository activiteRepository;

	@Autowired
	private ComposanteRepository ComposanteRepository;

	@Autowired
	private CollaborateurRepository CollaborateurRepository;

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

	@Override
	public List<Activite> findActivitiesByCollaborateur(int idCollaborateur) {
		return this.activiteRepository
				.findByCollaborateurs(this.CollaborateurRepository.findOneByIdCollaborateur(idCollaborateur));
	}

	@Override
	public Activite addActivite(Activite activite) {
		return this.activiteRepository.save(activite);
	}

	@Override
	public List<Activite> findActivitiesByComposante(int idComposante) {
		return this.activiteRepository.findByComposante(this.ComposanteRepository.findOneByIdComposante(idComposante));
	}

	@Override
	public List<Activite> findActivitiesByAnimateurTerrain(int idCollaborateur) {
		return this.activiteRepository
				.findByAnimateurTerrain(this.CollaborateurRepository.findOneByIdCollaborateur(idCollaborateur));
	}

	@Override
	public Activite findAcitiviteById(int idActivite) {
		return this.activiteRepository.findOneByIdActivite(idActivite);
	}

	@Override
	public Activite updateActiviteEtat(Activite activite) {
		return this.activiteRepository.saveAndFlush(activite);
	}

	@Override
	public void removeActivite(Activite activite) {
		this.activiteRepository.delete(activite);
	}

}
