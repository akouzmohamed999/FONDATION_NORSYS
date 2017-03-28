package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Projet;

@Service
public interface ProjetService {

	List<Projet> findAllProjets();

	List<Projet> findProjetsByIntitule(String intitule);

	List<Projet> findProjetsByCategorie(String categorie);

}
