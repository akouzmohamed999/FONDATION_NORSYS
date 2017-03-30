package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Activite;

@Service
public interface ActiviteService {

	List<Activite> findAllActivities();

}
