package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;
import fr.norsys.fondation.entities.Collaborateur;

@Service
public interface CollaborateurService {

	Collaborateur findCollaborateurByName(String string);
	
	Collaborateur findCollaborateurByIdCollaborateur(int idCollaborateur);

	Collaborateur findCollaborateurByEmail(String email);

	void deleteCollaborateur(Collaborateur collaborateur);
	
	List<Collaborateur> findAllCollaborateur();
	
	List<Collaborateur> findCollaborateurs();

	List<Collaborateur> findColllaborateursByComposante(int idComposante);

	Collaborateur updateCollaborateur(Collaborateur collaborateur);
	
	Collaborateur AddCollaborateur(Collaborateur collaborateur);
	
	void  DeleteCollaborateur(Collaborateur collaborateur);

}
