package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.entities.Responsable;
import fr.norsys.fondation.repositories.ProjetRepository;
import fr.norsys.fondation.services.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService {

	@Autowired
	ProjetRepository projetRepository;

	@Override
	public List<Projet> findAllProjets() {
		return this.projetRepository.findAll();
	}

	@Override
	public List<Projet> findProjetsByIntitule(String intitule) {
		return this.projetRepository.findByIntitule(intitule);
	}

	@Override
	public List<Projet> findProjetsByCategorie(String categorie) {
		return this.projetRepository.findByCategorie(categorie);
	}

	public List<Projet> findProjetByResponsable(Responsable responsable) {
		return this.projetRepository.findByResponsable(responsable);
	}
}
