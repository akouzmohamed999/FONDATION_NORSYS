package fr.norsys.fondation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.Administrateur;
import fr.norsys.fondation.repositories.AdministrateurRepository;
import fr.norsys.fondation.services.AdministrateurService;

@Service
public class AdministrateurServiceImpl implements AdministrateurService {

	@Autowired
	AdministrateurRepository administrateurRepository;

	@Override
	public List<Administrateur> findAllAdministrateur() {
		return this.administrateurRepository.findAll();
	}

	@Override
	public Administrateur findAdministrateurById(int IdAdministrateur) {
		return this.administrateurRepository.findOneByIdCollaborateur(IdAdministrateur);
	}

	@Override
	public Administrateur addAdministrateur(Administrateur administrateur) {
		return  this.administrateurRepository.save(administrateur);
	}

	@Override
	public Administrateur updateAdministrateur(Administrateur administrateur) {
		return this.administrateurRepository.saveAndFlush(administrateur); 
		}

	@Override
	public void deleteAdministrateur(Administrateur administrateur) {
		this.administrateurRepository.delete(administrateur);
	}

	@Override
	public Administrateur findAdministrateurByEmail(String email) {
		return this.administrateurRepository.findOneByEmail(email);
	}

	
}
