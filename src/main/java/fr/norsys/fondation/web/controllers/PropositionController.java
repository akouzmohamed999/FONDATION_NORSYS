package fr.norsys.fondation.web.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.norsys.fondation.entities.Proposition;
import fr.norsys.fondation.services.PropositionService;

@RestController
public class PropositionController {

	@Autowired
	PropositionService propositionService;

	@RequestMapping(value = "/public/addProposition", method = RequestMethod.POST)
	public Proposition addproposition(@RequestBody Proposition proposition) {
		return this.propositionService.addProposition(proposition);
	}

	@RequestMapping(value = "/administrateur/propositionById")
	public Proposition findpropositionById(@RequestParam int idProposition) {
		return this.propositionService.findPropositionById(idProposition);
	}

	@RequestMapping(value = "/administrateur/propositions")
	public List<Proposition> findAllProposition() {
		return this.propositionService.findAllProposition();
	}

	@RequestMapping(value = "/administrateur/propositionsNonVue")
	public List<Proposition> findNonVueProposition() {
		return this.propositionService.findNonVuePropositions();
	}

	@RequestMapping(value = "/administrateur/propositionsFavoris")
	public List<Proposition> findFavorisProposition() {
		return this.propositionService.findFavorisPropositions();
	}

	@RequestMapping(value = "/administrateur/deleteProposition", method = RequestMethod.DELETE)
	public Proposition deleteProposition(@RequestParam int idProposition) {
		return this.propositionService.addProposition(this.propositionService.findPropositionById(idProposition));
	}

	@RequestMapping(value = "/administrateur/updateProposition", method = RequestMethod.PUT)
	public Proposition updateProposition(@RequestBody Proposition proposition) {
		return this.propositionService.updateProposition(proposition);
	}

	FTPClient ftpClient = new FTPClient();

	@PostMapping("/public/addFichierProposition")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {

		if (uploadfile.isEmpty()) {
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}

		try {
			this.ftpClient.connect("localhost");
			this.ftpClient.login("admin", "admin");

			File convFile = new File(uploadfile.getOriginalFilename());
			uploadfile.transferTo(convFile);
			InputStream targetStream = new FileInputStream(convFile);

			// Store file to server
			this.ftpClient.changeWorkingDirectory("/Propositions");
			this.ftpClient.storeFile(uploadfile.getOriginalFilename(), targetStream);
			this.ftpClient.logout();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity("Successfully uploaded - " + uploadfile.getOriginalFilename(), new HttpHeaders(),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/administrateur/downloadAnnexe")
	public void retrieveDocument(@RequestParam String file, HttpServletResponse response) throws IOException {

		response.setContentType("APPLICATION_OCTET_STREAM");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Disposition", "attachment; filename=" + file);

		this.ftpClient.connect("localhost");
		this.ftpClient.login("admin", "admin");

		this.ftpClient.changeWorkingDirectory("/Propositions");
		InputStream in = this.ftpClient.retrieveFileStream(file);
		try {
			IOUtils.copy(in, response.getOutputStream());
			in.close();
			response.flushBuffer();
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {

		}
	}

}
