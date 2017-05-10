package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Partenaire;

@Service
public interface PartenaireService {

	List<Partenaire> findAllPartenaires();

	Partenaire updatePartenaire(Partenaire partenaire);
}
