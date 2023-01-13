package com.mng.bridgestone.service.impl;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mng.bridgestone.entity.FileData;
import com.mng.bridgestone.repository.FileDataRepository;

@Service
public class StorageService {
	@Autowired
	private FileDataRepository fileDataRepository;

	private final String FOLDER_PATH = "F:/Barcode/";
	
	//private final Path root = Paths.get("uploads");

	
//	public void init() {
//		try {
//			Files.createDirectories(root);
//		} catch (IOException e) {
//			throw new RuntimeException("Could not initialize folder for upload!");
//		}
//	}

	public String uploadImageToFileSystem(MultipartFile file) throws IOException {
		String filepath = FOLDER_PATH + file.getOriginalFilename();

		FileData fileData = fileDataRepository.save(FileData.builder().name(file.getOriginalFilename())
				.type(file.getContentType()).filePath(filepath).build());
		file.transferTo(new File(filepath));

		if (fileData != null) {
			return "file uploaded successfully:" + filepath;
		}

		return null;

	}

	public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
		Optional<FileData> findByName = fileDataRepository.findByName(fileName);
		String filepath = findByName.get().getFilePath();
		byte[] images = Files.readAllBytes(new File(filepath).toPath());
		return images;

	} 

}
