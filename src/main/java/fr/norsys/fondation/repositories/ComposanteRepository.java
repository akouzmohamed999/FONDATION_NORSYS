package fr.norsys.fondation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Composante;
import fr.norsys.fondation.entities.Projet;
import fr.norsys.fondation.entities.Thematique;

public interface ComposanteRepository extends JpaRepository<Composante, IncompatibleClassChangeError> {

	Composante findOneByIdComposante(int idComposante);

	List<Composante> findByProjet(Projet projet);

	List<Composante> findByThematique(Thematique thematique);

}
