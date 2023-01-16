package com.mng.bridgestone.controller;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mng.bridgestone.entity.FileData;
import com.mng.bridgestone.service.impl.StorageService;



@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/image")
public class FileDataController {

	@Autowired
	private StorageService service;
	
	

	@PostMapping("/fileSystem")
	public ResponseEntity<?> uploadToFileSystem(@RequestParam("image") MultipartFile file) throws IOException {
		
		String uploadImageToFileSystem = service.uploadImageToFileSystem(file);

		return ResponseEntity.status(HttpStatus.OK).body(uploadImageToFileSystem);

	}

	@GetMapping("/fileSystem/{fileName}")
	public ResponseEntity<?> downloadFromFileSystem(@PathVariable String fileName) throws IOException {

		byte[] downloadImageFromFileSystem = service.downloadImageFromFileSystem(fileName);

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png"))
				.body(downloadImageFromFileSystem);

	}

	@GetMapping("/fileSystem/getAll")
	public ResponseEntity<?> getAllImageListFromDb( ) {
		List<FileData> allImageListFromDb = service.getAllImageListFromDb();
		return ResponseEntity.status(HttpStatus.OK)
				.body(allImageListFromDb);
	}
}

