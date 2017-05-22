package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.RendezVous;

public interface RendezVousRepository extends JpaRepository<RendezVous, Integer> {

	RendezVous findOneByIdRendezVous(int idRendezVous);

}
