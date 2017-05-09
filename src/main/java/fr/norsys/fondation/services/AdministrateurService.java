package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Administrateur;

@Service
public interface AdministrateurService {

	List<Administrateur> findAllAdministrateur();

	Administrateur findAdministrateurById(int IdAdministrateur);
}
