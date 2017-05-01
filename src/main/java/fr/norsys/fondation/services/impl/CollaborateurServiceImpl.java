package fr.norsys.fondation.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.repositories.CollaborateurRepository;
import fr.norsys.fondation.services.ActiviteService;
import fr.norsys.fondation.services.CollaborateurService;

@Service
public class CollaborateurServiceImpl implements CollaborateurService {

	@Autowired
	CollaborateurRepository collaborateurRepository;

	@Autowired
	ActiviteService activiteService;

	@Override
	public Collaborateur findCollaborateurByName(String nom) {
		return this.collaborateurRepository.findOneByNom(nom);
	}

	@Override
	public List<Collaborateur> findAllCollaborateur() {
		return this.collaborateurRepository.findAll();
	}

	@Override
	public Collaborateur findCollaborateurByEmail(String email) {
		return this.collaborateurRepository.findOneByEmail(email);
	}

	@Override
	public List<Collaborateur> findColllaborateursByComposante(int idComposante) {
		List<Activite> activities = this.activiteService.findActivitiesByComposante(idComposante);
		List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
		activities.forEach(a -> collaborateurs.addAll(this.collaborateurRepository.findByActivites(a)));
		Set<Collaborateur> set = new HashSet<>();
		set.addAll(collaborateurs);
		collaborateurs.clear();
		collaborateurs.addAll(set);
		return collaborateurs;
	}

}
