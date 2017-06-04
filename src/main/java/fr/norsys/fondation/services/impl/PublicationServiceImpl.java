package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Publication;
import fr.norsys.fondation.repositories.PublicationRepository;
import fr.norsys.fondation.services.PublicationService;

@Service
public class PublicationServiceImpl implements PublicationService{

	@Autowired 
	PublicationRepository publicationRepository;
	
	@Override
	public List<Publication> findAllPublications() {
		return this.publicationRepository.findAll();
	}

	@Override
	public List<Publication> findAllVisiblePublications() {
		return this.publicationRepository.findByVisible(true);
	}

	@Override
	public Publication addPublication(Publication publication) {
		return this.publicationRepository.save(publication);
	}

	@Override
	public Publication modifierPublication(Publication publication) {
		return this.publicationRepository.saveAndFlush(publication);
	}

	@Override
	public byte[] findPublicationImages(int idPublication) {
		return this.findPublicationById(idPublication).getPhoto();
	}

	@Override
	public void deletePublication(Publication publication) {
		this.publicationRepository.delete(publication);		
	}

	@Override
	public Publication findPublicationById(int idPublication) {
		return this.publicationRepository.findOneByIdPublication(idPublication);
	}

}
