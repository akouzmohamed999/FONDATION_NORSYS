package fr.norsys.fondation.web.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RapportController {

	FTPClient ftpClient = new FTPClient();
	String filename = "data.txt";

	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "/home/mohamed/Bureau/fondation/shares/";

	@PostMapping("/responsable/addRapport")
	// @RequestMapping(value = "/responsable/addRapport", method =
	// RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA)
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
			this.ftpClient.changeWorkingDirectory("/Rapports");
			this.ftpClient.storeFile(uploadfile.getOriginalFilename(), targetStream);
			this.ftpClient.logout();
			// this.saveUploadedFiles(Arrays.asList(uploadfile));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity("Successfully uploaded - " + uploadfile.getOriginalFilename(), new HttpHeaders(),
				HttpStatus.OK);

	}

	private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue; // next pls
			}

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

		}

	}

}
