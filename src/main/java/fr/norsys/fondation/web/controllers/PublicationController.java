package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Publication;
import fr.norsys.fondation.services.PublicationService;

@RestController
public class PublicationController {

	@Autowired
	PublicationService publicationSerivce;
	
	@RequestMapping(value="/administrateur/publicationById")
	public Publication findPublicationById(@RequestParam int idPublication){
		return this.publicationSerivce.findPublicationById(idPublication);
	}
	
	@RequestMapping(value="/administrateur/publications")
	public List<Publication> findPublications(){
		return this.publicationSerivce.findAllPublications();
	}
	
	@RequestMapping(value="/public/visiblePublications")
	public List<Publication>  findVisiblePublications(){
		return this.publicationSerivce.findAllVisiblePublications();
	}
	
	@RequestMapping(value="/administrateur/addPublication",method=RequestMethod.POST)
	public Publication addPublication(@RequestBody Publication publication){
		return this.publicationSerivce.addPublication(publication);
	}
	
	
	@RequestMapping(value="/administrateur/updatePublication",method=RequestMethod.PUT)
	public Publication updatePublicationById(@RequestBody Publication publication){
		return this.publicationSerivce.modifierPublication(publication);
	}
	
	@RequestMapping(value="/administrateur/deletePublication",method=RequestMethod.DELETE)
	public void deletePublicationById(@RequestParam int idPublication){
		this.publicationSerivce.deletePublication(this.publicationSerivce.findPublicationById(idPublication));
	}
	
	
	@RequestMapping(value="/public/getPublictionImage")
	public byte[] getPublicationImage(@RequestParam int idPublication){
		return this.publicationSerivce.findPublicationImages(idPublication);
	}
	
	
	
}
