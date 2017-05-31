package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Administrateur;
import fr.norsys.fondation.entities.Collaborateur;

@Service
public interface AdministrateurService {

	List<Administrateur> findAllAdministrateur();

	Administrateur findAdministrateurById(int IdAdministrateur);
	
	Administrateur findAdministrateurByEmail(String email);
	
	Administrateur addAdministrateur(Administrateur administrateur);
	
	Administrateur updateAdministrateur(Administrateur administrateur);
	
	void deleteAdministrateur(Administrateur administrateur);
}
