package fr.norsys.fondation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Benificiaire;
import fr.norsys.fondation.repositories.BenificiaireRepository;
import fr.norsys.fondation.services.BenificiaireService;

@Service
public class BenificiaireServiceImpl implements BenificiaireService {

	@Autowired
	BenificiaireRepository benificiaireRepository;

	@Override
	public Benificiaire updateBenificiare(Benificiaire benificiaire) {
		return this.benificiaireRepository.saveAndFlush(benificiaire);
	}

}
