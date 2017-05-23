package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Proposition;
import fr.norsys.fondation.repositories.PropositionRepository;
import fr.norsys.fondation.services.PropositionService;

@Service
public class PropositionServiceImpl implements PropositionService {

	@Autowired
	PropositionRepository propositionRepository;

	@Override
	public List<Proposition> findAllProposition() {
		return this.propositionRepository.findAll();
	}

	@Override
	public List<Proposition> findNonVuePropositions() {
		return this.propositionRepository.findByEtat("NonVue");
	}

	@Override
	public List<Proposition> findFavorisPropositions() {
		return this.propositionRepository.findByEtat("Favoris");
	}

	@Override
	public Proposition addProposition(Proposition proposition) {
		return this.propositionRepository.save(proposition);
	}

	@Override
	public void deleteProposition(Proposition proposition) {
		this.propositionRepository.delete(proposition);
	}

	@Override
	public Proposition findPropositionById(int idProposition) {
		return this.propositionRepository.findOneByIdProposition(idProposition);
	}

	@Override
	public Proposition updateProposition(Proposition proposition) {
		return this.propositionRepository.saveAndFlush(proposition);
	}

}
