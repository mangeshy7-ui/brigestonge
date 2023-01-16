package com.mng.bridgestone.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mng.bridgestone.entity.FileData;

public interface FileDataService {
	public void init();
	public String uploadImageToFileSystem(MultipartFile file) throws IOException;
	public byte[] downloadImageFromFileSystem(String fileName) throws IOException;
	public List<FileData> getAllImageListFromDb();
}
