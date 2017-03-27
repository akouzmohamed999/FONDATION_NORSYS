package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {

}
