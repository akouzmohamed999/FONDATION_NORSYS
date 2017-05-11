package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Partenaire;

@Service
public interface PartenaireService {

	List<Partenaire> findAllPartenaires();

	Partenaire addPartenaire(Partenaire partenaire);

	Partenaire updatePartenaire(Partenaire partenaire);

	Partenaire findPartenaireById(int idPartenaire);

	void deletePartenaire(Partenaire partenaire);
}
