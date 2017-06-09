package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.norsys.fondation.entities.Publication;
import fr.norsys.fondation.services.PublicationService;

@RestController
public class PublicationController {

	Logger logger = LoggerFactory.getLogger(PublicationController.class);

	@Autowired
	PublicationService publicationSerivce;

	@RequestMapping(value = "/administrateur/publicationById")
	public Publication findPublicationById(@RequestParam int idPublication) {
		return this.publicationSerivce.findPublicationById(idPublication);
	}

	@RequestMapping(value = "/administrateur/publications")
	public List<Publication> findPublications() {
		return this.publicationSerivce.findAllPublications();
	}

	@RequestMapping(value = "/public/visiblePublications")
	public List<Publication> findVisiblePublications() {
		return this.publicationSerivce.findAllVisiblePublications();
	}

	@RequestMapping(value = "/administrateur/addPublication", method = RequestMethod.POST)
	public Publication addPublication(@RequestBody Publication publication) {
		return this.publicationSerivce.addPublication(publication);
	}

	@RequestMapping(value = "/administrateur/updatePublication", method = RequestMethod.PUT)
	public Publication updatePublicationById(@RequestBody Publication publication) {
		return this.publicationSerivce.modifierPublication(publication);
	}

	@RequestMapping(value = "/administrateur/deletePublication", method = RequestMethod.DELETE)
	public void deletePublicationById(@RequestParam int idPublication) {
		this.publicationSerivce.deletePublication(this.publicationSerivce.findPublicationById(idPublication));
	}

	@RequestMapping(value = "/public/getPublictionImage")
	public byte[] getPublicationImage(@RequestParam int idPublication) {
		return this.publicationSerivce.findPublicationImages(idPublication);
	}

	@PostMapping("/administrateur/addImagePublication")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile,
			@RequestParam("idPublication") int idPublication) {

		if (uploadfile.isEmpty()) {
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}

		try {
			Publication publication = this.publicationSerivce.findPublicationById(idPublication);
			publication.setPhoto(uploadfile.getBytes());
			this.publicationSerivce.modifierPublication(publication);
		} catch (Exception e) {
			this.logger.info("ERREUR DEPUIS PUBLICATION CONTROLLER " + e);
		}

		return new ResponseEntity("Successfully uploaded - " + uploadfile.getOriginalFilename(), new HttpHeaders(),
				HttpStatus.OK);

	}

}
