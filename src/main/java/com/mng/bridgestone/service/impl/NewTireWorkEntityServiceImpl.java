package com.mng.bridgestone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mng.bridgestone.entity.NewTireWorkEntity;
import com.mng.bridgestone.repository.NewTireWorkEntityRepository;
import com.mng.bridgestone.service.NewTireWorkEntityService;

@Service
public class NewTireWorkEntityServiceImpl implements NewTireWorkEntityService {

	@Autowired
	private NewTireWorkEntityRepository newTireWorkEntityRepository;

	@Override
	public NewTireWorkEntity saveNewTireWorkEntity(NewTireWorkEntity newTireWorkEntity) {
		NewTireWorkEntity save = newTireWorkEntityRepository.save(newTireWorkEntity);
		return save;
	}

	@Override
	public void updateNewTireWorkEntity(NewTireWorkEntity newTireWorkEntity) {
		newTireWorkEntityRepository.save(newTireWorkEntity);
	}

	@Override
	public Optional<NewTireWorkEntity> findNewTireWorkEntityById(String id) {
		Optional<NewTireWorkEntity> findById = newTireWorkEntityRepository.findById(id);
		return findById;
	}

	@Override
	public List<NewTireWorkEntity> findAllDataFromNewTireWorkEntity() {
		List<NewTireWorkEntity> findAll = newTireWorkEntityRepository.findAll();
		return findAll;
	}

	@Override
	public List<NewTireWorkEntity> deleteNewTireWorkEntityById(String id) {
		newTireWorkEntityRepository.deleteById(id);
		return newTireWorkEntityRepository.findAll();
	}

}
