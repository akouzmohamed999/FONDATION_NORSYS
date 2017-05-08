package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Thematique;

@Service
public interface ThematiqueService {

	List<Thematique> findAllThematiques();
}
