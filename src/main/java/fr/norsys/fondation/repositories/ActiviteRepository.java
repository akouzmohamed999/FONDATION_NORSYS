package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Integer> {

}
