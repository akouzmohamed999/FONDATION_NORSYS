package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Publication;

@Service
public interface PublicationService {
	
	List<Publication> findAllPublications();
	
	List<Publication> findAllVisiblePublications();
	
	Publication addPublication(Publication publication);
	
	Publication modifierPublication(Publication publication);
	
	byte[] findPublicationImages(int idPublication);
		
	void deletePublication(Publication publication);
	
	Publication findPublicationById(int idPublication);

}
