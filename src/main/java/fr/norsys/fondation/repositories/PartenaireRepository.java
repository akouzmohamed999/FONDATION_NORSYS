package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Partenaire;

public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {

}
