package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Composante;
import fr.norsys.fondation.entities.Thematique;

public interface ThematiqueRepository extends JpaRepository<Thematique, Integer> {

	Thematique findByIdThematique(int idThematique);

	Thematique findByComposantes(Composante composante);

}
