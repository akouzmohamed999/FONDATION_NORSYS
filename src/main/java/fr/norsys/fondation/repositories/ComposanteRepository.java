package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Composante;

public interface ComposanteRepository extends JpaRepository<Composante, IncompatibleClassChangeError> {

}
