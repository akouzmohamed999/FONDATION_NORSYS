package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Partenaire;
import fr.norsys.fondation.repositories.PartenaireRepository;
import fr.norsys.fondation.services.PartenaireService;

@Service
public class PartenaireServiceImpl implements PartenaireService {

	@Autowired
	PartenaireRepository partenaireRepository;

	@Override
	public List<Partenaire> findAllPartenaires() {
		return this.partenaireRepository.findAll();
	}

	@Override
	public Partenaire updatePartenaire(Partenaire partenaire) {
		return this.partenaireRepository.saveAndFlush(partenaire);
	}

	@Override
	public Partenaire addPartenaire(Partenaire partenaire) {
		return this.partenaireRepository.save(partenaire);
	}

	@Override
	public Partenaire findPartenaireById(int idPartenaire) {
		return this.partenaireRepository.findOneByIdPartenaire(idPartenaire);
	}

	@Override
	public void deletePartenaire(Partenaire partenaire) {
		this.partenaireRepository.delete(partenaire);

	}

}
