package fr.norsys.fondation.web.controllers;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.norsys.fondation.entities.Administrateur;
import fr.norsys.fondation.entities.Collaborateur;
import fr.norsys.fondation.entities.Publication;
import fr.norsys.fondation.entities.Responsable;
import fr.norsys.fondation.services.AdministrateurService;
import fr.norsys.fondation.services.CollaborateurService;
import fr.norsys.fondation.services.ResponsableService;

@RestController
public class CollaborateurController {

	@Autowired
	CollaborateurService collaborateurService;

	@Autowired
	ResponsableService responsableService;

	@Autowired
	AdministrateurService administrateurService;
	
	Logger logger = LoggerFactory.getLogger(CollaborateurController.class);

	@RequestMapping(value = "/collaborateur/collaborateur")
	public List<Collaborateur> findCollaborateurByComposanet(@RequestParam int idComposante) {
		return this.collaborateurService.findColllaborateursByComposante(idComposante);
	}

	@RequestMapping(value = "/administrateur/collaborateurById")
	public Collaborateur findCollaborateurByIdCollaborateur(@RequestParam int idCollaborateur) {
		return this.collaborateurService.findCollaborateurByIdCollaborateur(idCollaborateur);
	}

	@RequestMapping(value = "/collaborateur/collaborateurs")
	public List<Collaborateur> findCollaborateurs() {
		return this.collaborateurService.findAllCollaborateur();
	}

	@RequestMapping(value = "/responsable/allCollaborateurs")
	public List<Collaborateur> findCollaborateursOnly() {
		return this.collaborateurService.findCollaborateurs();
	}

	@RequestMapping(value = "/administrateur/administrateurs")
	public List<Administrateur> findAllAdministrateur() {
		return this.administrateurService.findAllAdministrateur();
	}

	@RequestMapping(value = "/administrateur/responsables")
	public List<Responsable> findAllResponsables() {
		return this.responsableService.findAllResponsables();

	}

	@RequestMapping(value = "/administrateur/adminById")
	public Administrateur findAdminById(@RequestParam int idAdministrateur) {
		return this.administrateurService.findAdministrateurById(idAdministrateur);
	}

	@RequestMapping(value = "/administrateur/AddCollaborateur", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Collaborateur AddCollaborateur(@RequestBody Collaborateur collaborateur) {
		return this.collaborateurService.AddCollaborateur(collaborateur);
	}

	@RequestMapping(value = "/administrateur/updateCollaborateur", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Collaborateur updateCollaborateur(@RequestBody Collaborateur collaborateur) {
		return this.collaborateurService.updateCollaborateur(collaborateur);
	}

	@RequestMapping(value = "/administrateur/DeleteCollaborateur", method = RequestMethod.DELETE)
	public void DeleteCollaborateur(@RequestParam int idCollaborateur, Principal prinipal) {
		Administrateur administrateur = this.administrateurService.findAdministrateurByEmail(prinipal.getName());
		Collaborateur collaborateur = this.collaborateurService.findCollaborateurByIdCollaborateur(idCollaborateur);
		this.collaborateurService.deleteCollaborateur(collaborateur, administrateur);
	}
	
	@PostMapping("/collaborateur/addImageCollaborateur")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile,
			@RequestParam("idCollaborateur") int idCollaborateur) {

		if (uploadfile.isEmpty()) {
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}

		try {
			Collaborateur collaborateur = this.collaborateurService.findCollaborateurByIdCollaborateur(idCollaborateur);
			collaborateur.setPhoto(uploadfile.getBytes());
			this.collaborateurService.updateCollaborateur(collaborateur);
		} catch (Exception e) {
			this.logger.info("ERREUR DEPUIS PUBLICATION CONTROLLER " + e);
		}

		return new ResponseEntity("Successfully uploaded - " + uploadfile.getOriginalFilename(), new HttpHeaders(),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/public/getCollaborateurImage")
	public byte[] getPublicationImage(@RequestParam int idCollaborateur) {
		return this.collaborateurService.findCollaborateurByIdCollaborateur(idCollaborateur).getPhoto();
	}
}
