package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Administrateur;
import fr.norsys.fondation.entities.Responsable;

@Service
public interface ResponsableService {

	List<Responsable> findAllResponsables();

	Responsable findResponsableById(int idResponsable);
	
	Responsable addResponsable(Responsable responsable);
	
	Responsable updateResponsable(Responsable responsable);
	
	void deleteResponsable(Responsable responsable);
}
