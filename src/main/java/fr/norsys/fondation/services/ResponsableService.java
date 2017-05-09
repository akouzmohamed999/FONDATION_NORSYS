package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Responsable;

@Service
public interface ResponsableService {

	List<Responsable> findAllResponsables();
}
