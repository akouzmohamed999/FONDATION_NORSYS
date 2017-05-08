package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Thematique;
import fr.norsys.fondation.services.ThematiqueService;

@RestController
public class ThematiqueController {

	@Autowired
	ThematiqueService thematiqueSerivce;

	@RequestMapping("/responsable/thematiques")
	public List<Thematique> findAllThematiques() {
		return this.thematiqueSerivce.findAllThematiques();
	}
}
