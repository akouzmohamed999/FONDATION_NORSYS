package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Collaborateur;

@Service
public interface CollaborateurService {

	Collaborateur findCollaborateurByName(String string);

	List<Collaborateur> findAllCollaborateur();

}
