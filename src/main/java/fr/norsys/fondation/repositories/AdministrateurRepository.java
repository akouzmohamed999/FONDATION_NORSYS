package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Administrateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {

}
