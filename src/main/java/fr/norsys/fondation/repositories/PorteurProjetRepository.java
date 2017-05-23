package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.PorteurProjet;

public interface PorteurProjetRepository extends JpaRepository<PorteurProjet, Integer> {

	PorteurProjet findOneByIdPorteur(int idPorteurProjet);
}
