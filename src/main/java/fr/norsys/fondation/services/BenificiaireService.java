package fr.norsys.fondation.services;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Benificiaire;

@Service
public interface BenificiaireService {

	Benificiaire updateBenificiare(Benificiaire benificiaire);

	Benificiaire addBenificiaire(Benificiaire benificiaire);
}
