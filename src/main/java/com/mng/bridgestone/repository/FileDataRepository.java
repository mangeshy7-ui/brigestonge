package com.mng.bridgestone.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mng.bridgestone.entity.FileData;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long> {
     
	@Transactional
	Optional<FileData> findByName(String fileName);

}