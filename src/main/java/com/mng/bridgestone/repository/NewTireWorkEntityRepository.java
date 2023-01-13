package com.mng.bridgestone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mng.bridgestone.entity.NewTireWorkEntity;

@Repository
public interface NewTireWorkEntityRepository  extends JpaRepository<NewTireWorkEntity, String>{

}
