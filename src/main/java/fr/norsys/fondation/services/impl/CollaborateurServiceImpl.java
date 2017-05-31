package fr.norsys.fondation.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.entities.Administrateur;
import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.entities.Responsable;
import fr.norsys.fondation.repositories.AdministrateurRepository;
import fr.norsys.fondation.repositories.CollaborateurRepository;
import fr.norsys.fondation.repositories.ProjetRepository;
import fr.norsys.fondation.repositories.ResponsableRepository;
import fr.norsys.fondation.services.ActiviteService;
import fr.norsys.fondation.services.CollaborateurService;

@Service
public class CollaborateurServiceImpl implements CollaborateurService {

	@Autowired
	CollaborateurRepository collaborateurRepository;

	@Autowired
	ActiviteService activiteService;
	
	@Autowired
	AdministrateurRepository administrateurRepository;
	
	@Autowired
	ResponsableRepository responsableRepository;
	
	@Autowired
	ProjetRepository projetRepository;

	@Override
	public Collaborateur findCollaborateurByName(String nom) {
		return this.collaborateurRepository.findOneByNom(nom);
	}

	@Override
	public List<Collaborateur> findAllCollaborateur() {
		List<Collaborateur> collaborateurs=this.collaborateurRepository.findAll();
		collaborateurs.removeAll(this.administrateurRepository.findAll());
		collaborateurs.removeAll(this.responsableRepository.findAll());
		return collaborateurs;
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

	@Override
	public Collaborateur updateCollaborateur(Collaborateur collaborateur) {
		if(this.administrateurRepository.findOneByIdCollaborateur(collaborateur.getIdCollaborateur()) != null){
			Administrateur administrateur = this.administrateurRepository.findOneByIdCollaborateur(collaborateur.getIdCollaborateur());
			administrateur.setNom(collaborateur.getNom());
			administrateur.setPrenom(collaborateur.getPrenom());
			administrateur.setAdresse(collaborateur.getAdresse());
			administrateur.setCIN(collaborateur.getCIN());
			administrateur.setAdresse(collaborateur.getNumeroTelephone());
			administrateur.setLieuNaissance(collaborateur.getLieuNaissance());
			administrateur.setPassword(collaborateur.getPassword());
			administrateur.setEmail(collaborateur.getEmail());
			administrateur.setDateNaissance(collaborateur.getDateNaissance());
			return this.administrateurRepository.saveAndFlush(administrateur);
		}else if(this.responsableRepository.findOneByIdCollaborateur(collaborateur.getIdCollaborateur()) != null){
			Responsable responsable = this.responsableRepository.findOneByIdCollaborateur(collaborateur.getIdCollaborateur());
			responsable.setNom(collaborateur.getNom());
			responsable.setPrenom(collaborateur.getPrenom());
			responsable.setAdresse(collaborateur.getAdresse());
			responsable.setCIN(collaborateur.getCIN());
			responsable.setAdresse(collaborateur.getNumeroTelephone());
			responsable.setLieuNaissance(collaborateur.getLieuNaissance());
			responsable.setPassword(collaborateur.getPassword());
			responsable.setEmail(collaborateur.getEmail());
			responsable.setDateNaissance(collaborateur.getDateNaissance());
			return this.responsableRepository.saveAndFlush(responsable);
		}else{
			return this.collaborateurRepository.saveAndFlush(collaborateur);	
		}
		
	}

	@Override
	public Collaborateur findCollaborateurByIdCollaborateur(int idCollaborateur) {
		return this.collaborateurRepository.findOneByIdCollaborateur(idCollaborateur);
	}

	@Override
	public Collaborateur AddCollaborateur(Collaborateur collaborateur) {
		return this.collaborateurRepository.save(collaborateur);
		
	}

	@Override
	public void deleteCollaborateur(Collaborateur collaborateur,Administrateur nouveauAdmin) {
		if(this.administrateurRepository.findOneByIdCollaborateur(collaborateur.getIdCollaborateur()) != null){
			Administrateur administrateur = this.administrateurRepository.findOneByIdCollaborateur(collaborateur.getIdCollaborateur());
			for (Projet projet : administrateur.getProjets()) {
				projet.setAdministrateur(nouveauAdmin);
				this.projetRepository.saveAndFlush(projet);
			}
			administrateur.getProjets().removeAll(administrateur.getProjets());
			this.administrateurRepository.saveAndFlush(administrateur);
			this.administrateurRepository.delete(administrateur);
		}else if(this.responsableRepository.findOneByIdCollaborateur(collaborateur.getIdCollaborateur()) != null){
			Responsable responsable = this.responsableRepository.findOneByIdCollaborateur(collaborateur.getIdCollaborateur());
			for (Projet projet : responsable.getProjets()) {
				projet.setResponsable(null);
				this.projetRepository.saveAndFlush(projet);
			}
			responsable.getProjets().removeAll(responsable.getProjets());
			this.responsableRepository.saveAndFlush(responsable);
			this.responsableRepository.delete(responsable);
			
		}else{
			for (Activite activite : collaborateur.getActivites()) {
				activite.getCollaborateurs().remove(collaborateur);
				this.activiteService.updateActiviteEtat(activite);
			}
			collaborateur.getActivites().removeAll(collaborateur.getActivites());
			this.collaborateurRepository.saveAndFlush(collaborateur);
			this.collaborateurRepository.delete(collaborateur);
		}
		
	}

	@Override
	public List<Collaborateur> findCollaborateurs() {
		return this.collaborateurRepository.findAll();
	}



}
