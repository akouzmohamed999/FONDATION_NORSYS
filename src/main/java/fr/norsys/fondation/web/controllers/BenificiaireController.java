package fr.norsys.fondation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.norsys.fondation.entities.Benificiaire;
import fr.norsys.fondation.services.BenificiaireService;

@RestController
public class BenificiaireController {

	@Autowired
	BenificiaireService benificiaireService;

	@RequestMapping(value = "/responsable/addBenificiaire", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Benificiaire addBenificiaire(@RequestBody Benificiaire benificiaire) {
		return this.benificiaireService.addBenificiaire(benificiaire);
	}

	@RequestMapping(value = "/responsable/benificiaires")
	public List<Benificiaire> findAllBenificiaires() {
		return this.benificiaireService.findAllBenficiaires();
	}

	@RequestMapping(value = "/responsable/findBenificiaire")
	public Benificiaire findBenificiaireByid(@RequestParam int idBenificiaire) {
		return this.benificiaireService.findOneByIdBenificiare(idBenificiaire);
	}

	@RequestMapping(value = "/responsable/updateBenificiaire", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Benificiaire updateBenificiaire(@RequestBody Benificiaire benificiaire) {
		return this.benificiaireService.updateBenificaire(benificiaire);
	}

	@RequestMapping(value = "/responsable/deleteBenificiaires", method = RequestMethod.DELETE)
	public void findAllBenificiaires(@RequestParam int idBenificiaire) {
		Benificiaire benificiaire = this.benificiaireService.findOneByIdBenificiare(idBenificiaire);
		this.benificiaireService.deleteBenificiaire(benificiaire);

	}

}
