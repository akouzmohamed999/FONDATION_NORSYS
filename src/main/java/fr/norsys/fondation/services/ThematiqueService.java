package fr.norsys.fondation.services;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Thematique;

@Service
public interface ThematiqueService {

	Thematique findThematiqueByComposante(int idComposante);
}
