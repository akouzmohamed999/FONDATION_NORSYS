package fr.norsys.fondation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.norsys.fondation.entities.RendezVous;

@Service
public interface RendezVousService {

	List<RendezVous> findAllRendezVous();

	RendezVous addRendezVous(RendezVous rendezVous);

	RendezVous updateRendezVous(RendezVous rendezVous);

	void deleteRendezVous(RendezVous rendezVous);

	RendezVous findRendezVousById(int idRendezVous);
}
