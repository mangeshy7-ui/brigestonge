package com.mng.bridgestone.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mng.bridgestone.entity.NewTireWorkEntity;
import com.mng.bridgestone.response.MessageResponse;
import com.mng.bridgestone.service.NewTireWorkEntityService;


@RestController
@RequestMapping("/newtire")

public class NewTireWorkEntityController {
	
	@Autowired
	private NewTireWorkEntityService entityService;
	
	
	@PostMapping("/saveNewTire")
	public ResponseEntity<MessageResponse> saveNewTireWorkEntity(@RequestBody NewTireWorkEntity newTireWorkEntity) {
		
		entityService.saveNewTireWorkEntity(newTireWorkEntity);
	
		return ResponseEntity.status(200).body(new MessageResponse("newTireWorkEntity successfully Register...!!"));
	}

	@PutMapping("/updateNewTire")
	public ResponseEntity<MessageResponse> updateNewTireWork (@RequestBody NewTireWorkEntity newTireWorkEntity) {
		
		entityService.updateNewTireWorkEntity(newTireWorkEntity);
	
		return ResponseEntity.status(200).body(new MessageResponse("newTireWorkEntity is successfully updated..!!"));
	}

	@GetMapping("/showNewTireById/{id}")
	public Optional<NewTireWorkEntity> showNewTireWorkById(@PathVariable String id) {
		
		Optional<NewTireWorkEntity> findNewTireWorkEntityById = entityService.findNewTireWorkEntityById(id);
		return findNewTireWorkEntityById;
	}

	@GetMapping("/showAllNewTireData")
	public List<NewTireWorkEntity> showNewTireWorkEntityData() {
		
		List<NewTireWorkEntity> findAllDataFromNewTireWorkEntity = entityService.findAllDataFromNewTireWorkEntity();
		return findAllDataFromNewTireWorkEntity;
		
	}

	@DeleteMapping("/deleteDriverByID/{id}")
	public ResponseEntity<MessageResponse> deleteNewTireWorkEntityById(@PathVariable String id) {
	
		entityService.deleteNewTireWorkEntityById(id);
		

		return ResponseEntity.status(200).body(new MessageResponse("newTireWorkEntity " + id + " is Successfully Deleted"));
	}

}

