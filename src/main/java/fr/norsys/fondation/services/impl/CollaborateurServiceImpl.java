package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.repositories.CollaborateurRepository;
import fr.norsys.fondation.services.CollaborateurService;

@Service
public class CollaborateurServiceImpl implements CollaborateurService {

	@Autowired
	CollaborateurRepository collaborateurRepository;

	@Override
	public Collaborateur findCollaborateurByName(String nom) {
		return this.collaborateurRepository.findByNom(nom).get(0);
	}

	@Override
	public Collaborateur AddCollaborateur(String nom, String prenom) {
		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setNom(nom);
		collaborateur.setPrenom(prenom);
		return this.collaborateurRepository.save(collaborateur);
	}

	@Override
	public List<Collaborateur> findAllCollaborateur() {
		return this.collaborateurRepository.findAll();
	}

}
