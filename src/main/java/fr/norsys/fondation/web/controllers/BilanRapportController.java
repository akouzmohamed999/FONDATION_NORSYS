package fr.norsys.fondation.web.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
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

import fr.norsys.fondation.entities.BilanProjet;
import fr.norsys.fondation.services.BilanProjetService;

@RestController
public class BilanRapportController {

	Logger logger = LoggerFactory.getLogger(BilanRapportController.class);

	@Autowired
	BilanProjetService bilanProjetService;

	FTPClient ftpClient = new FTPClient();

	@PostMapping("/responsable/addFichierBilan")
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
			this.ftpClient.changeWorkingDirectory("/Bilans");
			this.ftpClient.storeFile(uploadfile.getOriginalFilename(), targetStream);
			this.ftpClient.logout();

		} catch (Exception e) {
			this.logger.info("ERREUR DEPUIS BILANS RAPPORT " + e);
		} finally {
			if (targetStream != null) {
				targetStream.close();
			}
		}

		return new ResponseEntity("Successfully uploaded - " + uploadfile.getOriginalFilename(), new HttpHeaders(),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/responsable/addBilan", method = RequestMethod.POST)
	public BilanProjet addBilanProjet(@RequestBody BilanProjet bilanProjet) {
		return this.bilanProjetService.addBilanProjet(bilanProjet);
	}

	@RequestMapping(value = "/responsable/bilansProjetByProjet")
	public List<BilanProjet> findRapportProjetById(@RequestParam int idProjet) {
		return this.bilanProjetService.findAllBilansByIdProjet(idProjet);
	}

	@RequestMapping(value = "/responsable/bilans")
	public List<BilanProjet> findAllBilanProjet() {
		return this.bilanProjetService.findAllBilans();
	}

	@RequestMapping(value = "/responsable/downloadBilan")
	public void retrieveDocument(@RequestParam String file, HttpServletResponse response) throws IOException {

		response.setContentType("APPLICATION_OCTET_STREAM");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Disposition", "attachment; filename=" + file);

		this.ftpClient.connect("localhost");
		this.ftpClient.login("admin", "admin");

		this.ftpClient.changeWorkingDirectory("/Bilans");
		InputStream in = this.ftpClient.retrieveFileStream(file);
		try {
			IOUtils.copy(in, response.getOutputStream());
			in.close();
			response.flushBuffer();
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			this.logger.info("ERREUR DEPUIS BILANS RAPPORT " + e);
		}
	}

}
