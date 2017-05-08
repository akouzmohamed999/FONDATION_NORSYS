package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Thematique;
import fr.norsys.fondation.repositories.ThematiqueRepository;
import fr.norsys.fondation.services.ThematiqueService;

@Service
public class ThematiqueServiceImpl implements ThematiqueService {

	@Autowired
	ThematiqueRepository ThematiqueRepository;

	@Override
	public List<Thematique> findAllThematiques() {
		return this.ThematiqueRepository.findAll();
	}

}
