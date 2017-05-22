package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Proposition;

@Service
public interface PropositionService {

	List<Proposition> findAllProposition();

	List<Proposition> findNonVuePropositions();

	List<Proposition> findFavorisPropositions();

	Proposition addProposition(Proposition proposition);

	void deleteProposition(Proposition proposition);

	Proposition findPropositionById(int idProposition);
}
