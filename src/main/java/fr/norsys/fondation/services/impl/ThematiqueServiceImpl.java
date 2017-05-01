package fr.norsys.fondation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Thematique;
import fr.norsys.fondation.repositories.ThematiqueRepository;
import fr.norsys.fondation.services.ComposanteService;
import fr.norsys.fondation.services.ThematiqueService;

@Service
public class ThematiqueServiceImpl implements ThematiqueService {

	@Autowired
	ThematiqueRepository ThematiqueRepository;

	@Autowired
	ComposanteService composanteService;

	@Override
	public Thematique findThematiqueByComposante(int idComposante) {
		return this.ThematiqueRepository.findByComposantes(this.composanteService.findComposanteById(idComposante));
	}

}
