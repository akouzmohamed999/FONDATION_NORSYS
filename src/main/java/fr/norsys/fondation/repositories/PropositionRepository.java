package fr.norsys.fondation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Proposition;

public interface PropositionRepository extends JpaRepository<Proposition, Integer> {

	List<Proposition> findByEtat(String string);

	Proposition findOneByIdProposition(int idProposition);

}
