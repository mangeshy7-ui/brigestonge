package com.mng.bridgestone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mng.bridgestone.service.impl.StorageService;

@SpringBootApplication
public class BridgeStoneProjectApplication {
	@Autowired
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(BridgeStoneProjectApplication.class, args);
	}

	public void run(String[] arg) throws Exception {
		// this.storageService.deleteAll();
		this.storageService.init();
	}
}
