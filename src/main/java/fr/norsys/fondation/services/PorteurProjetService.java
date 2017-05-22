package fr.norsys.fondation.services;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.PorteurProjet;

@Service
public interface PorteurProjetService {

	PorteurProjet addPorteurProjet(PorteurProjet porteurProjet);
}
