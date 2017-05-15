package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Activite;
import fr.norsys.fondation.entities.Benificiaire;
import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.services.ActiviteService;
import fr.norsys.fondation.services.BenificiaireService;
import fr.norsys.fondation.services.CollaborateurService;

@RestController
public class ActiviteController {

	@Autowired
	ActiviteService activiteService;

	@Autowired
	CollaborateurService collaborateurService;

	@Autowired
	BenificiaireService benificiaireService;

	@RequestMapping(value = "/collaborateur/activite", method = RequestMethod.GET)
	public List<Activite> findActivitiesByIdComposante(@RequestParam int idComposante) {
		return this.activiteService.findActivitiesByComposante(idComposante);
	}

	@RequestMapping(value = "/collaborateur/activiteById", method = RequestMethod.GET)
	public Activite findActivityById(@RequestParam int idActivite) {
		return this.activiteService.findAcitiviteById(idActivite);
	}

	@RequestMapping(value = "/responsable/addActivite", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Activite addActivite(@RequestBody Activite activite) {
		System.out.println("L'ACTIVITE AJOUTE : " + activite);
		Activite storedActivite = this.activiteService.addActivite(activite);
		for (Collaborateur collaborateur : activite.getCollaborateurs()) {
			collaborateur.getActivites().add(activite);
			this.collaborateurService.updateCollaborateur(collaborateur);
		}

		for (Benificiaire benificiaire : activite.getBenificiaires()) {
			benificiaire.getActivites().add(activite);
			this.benificiaireService.updateBenificiare(benificiaire);
		}
		return storedActivite;
	}

	@RequestMapping(value = "/responsable/updateActivite", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Activite UpdateActivite(@RequestBody Activite activite) {
		System.out.println("L'ACTIVITE MODIFIE : " + activite);
		Activite storedActivite = this.activiteService.addActivite(activite);
		for (Collaborateur collaborateur : activite.getCollaborateurs()) {
			collaborateur.getActivites().add(activite);
			this.collaborateurService.updateCollaborateur(collaborateur);
		}

		for (Benificiaire benificiaire : activite.getBenificiaires()) {
			benificiaire.getActivites().add(activite);
			this.benificiaireService.updateBenificiare(benificiaire);
		}
		return storedActivite;
	}

	@RequestMapping(value = "/responsable/deleteActivite", method = RequestMethod.DELETE)
	public void deleteActivite(@RequestParam int idActivite) {
		Activite activite = this.activiteService.findAcitiviteById(idActivite);
		System.out.println("L'ACTIVITE Supprimée : " + activite);
		this.activiteService.removeActivite(activite);
	}

}
