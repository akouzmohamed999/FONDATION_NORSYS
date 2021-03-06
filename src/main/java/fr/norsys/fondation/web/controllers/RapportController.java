package fr.norsys.fondation.web.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import fr.norsys.fondation.entities.RapportProjet;
import fr.norsys.fondation.services.RapportProjetService;

@RestController
public class RapportController {

	Logger logger = LoggerFactory.getLogger(RapportController.class);

	@Autowired
	RapportProjetService rapportProjetService;

	FTPClient ftpClient = new FTPClient();

	@PostMapping("/responsable/addFichierRapport")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) throws IOException {

		if (uploadfile.isEmpty()) {
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}

		InputStream targetStream = null;
		try {
			this.ftpClient.connect("localhost");
			this.ftpClient.login("admin", "admin");

			File convFile = new File(uploadfile.getOriginalFilename());
			uploadfile.transferTo(convFile);

			targetStream = new FileInputStream(convFile);

			// Store file to server
			this.ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			this.ftpClient.changeWorkingDirectory("/Rapports");
			this.ftpClient.storeFile(uploadfile.getOriginalFilename(), targetStream);
			this.ftpClient.logout();

		} catch (Exception e) {
			this.logger.info("ERREUR DEPUIS RAPPORT CONTROLLER " + e);
		} finally {

			if (targetStream != null) {
				targetStream.close();
			}

		}

		return new ResponseEntity("Successfully uploaded - " + uploadfile.getOriginalFilename(), new HttpHeaders(),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/responsable/addRapport", method = RequestMethod.POST)
	public RapportProjet addRapportProjet(@RequestBody RapportProjet rapportProjet) {
		return this.rapportProjetService.addRapportProjet(rapportProjet);
	}

	@RequestMapping(value = "/responsable/rapportsProjetByProjet")
	public List<RapportProjet> findRapportProjetById(@RequestParam int idProjet) {
		return this.rapportProjetService.findRapportByIdProjet(idProjet);
	}

	@RequestMapping(value = "/responsable/rapports")
	public List<RapportProjet> findAllRapportProjet() {
		return this.rapportProjetService.findAllRapportProjets();
	}

	@RequestMapping(value = "/responsable/downloadRapport")
	public void retrieveDocument(@RequestParam String file, HttpServletResponse response) throws IOException {

		response.setContentType("APPLICATION_OCTET_STREAM");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Disposition", "attachment; filename=" + file);

		this.ftpClient.connect("localhost");
		this.ftpClient.login("admin", "admin");

		this.ftpClient.changeWorkingDirectory("/Rapports");
		InputStream in = this.ftpClient.retrieveFileStream(file);
		try {
			IOUtils.copy(in, response.getOutputStream());
			in.close();
			response.flushBuffer();
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			this.logger.info("ERREUR DEPUIS RAPPORT CONTROLLER " + e);
		}
	}

}
