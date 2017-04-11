package fr.norsys.fondation.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.repositories.ProjetRepository;
import fr.norsys.fondation.repositories.ResponsableRepository;
import fr.norsys.fondation.services.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService {

	@Autowired
	private ProjetRepository projetRepository;

	@Autowired
	private ResponsableRepository responsableRepository;

	@Override
	public List<Projet> findAllProjets() {
		return this.projetRepository.findAll();
	}

	@Override
	public List<Projet> findProjetsByIntitule(String intitule) {
		return this.projetRepository.findByIntitule(intitule);
	}

	@Override
	public List<Projet> findProjetsByResponsable(int idResponsable) {
		return this.projetRepository
				.findByResponsable(this.responsableRepository.findOneByIdCollaborateur(idResponsable));
	}

	@Override
	public List<Projet> findProjetsByDateDebut(Date dateDebut) {
		return this.projetRepository.findByDateDebut(dateDebut);
	}

	@Override
	public List<Projet> findProjetsByDateFin(Date dateFin) {
		return this.projetRepository.findByDateFin(dateFin);
	}

	@Override
	public Projet addProjet(Projet projet) {
		return this.projetRepository.save(projet);
	}

}
