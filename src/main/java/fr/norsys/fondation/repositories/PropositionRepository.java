package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Proposition;

public interface PropositionRepository extends JpaRepository<Proposition, Integer> {

}
