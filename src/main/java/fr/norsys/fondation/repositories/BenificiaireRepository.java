package fr.norsys.fondation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.norsys.fondation.entities.Benificiaire;

public interface BenificiaireRepository extends JpaRepository<Benificiaire, Integer> {

	Benificiaire findOneByIdBenificiaire(int IdBenificiaire);

}
