package com.mng.bridgestone.service;

import java.util.List;
import java.util.Optional;

import com.mng.bridgestone.entity.NewTireWorkEntity;





public interface NewTireWorkEntityService {
	
//	 public  Integer saveLoanForm(LoanForm paramLoanForm);
//
//	  public  List<LoanForm> getLoanForms();
//
//	  public  LoanForm getOneLoanForm(Integer paramInteger);
//
//	  public  void deleteLoanForm(Integer paramInteger);

	NewTireWorkEntity saveNewTireWorkEntity(NewTireWorkEntity newTireWorkEntity);

	void updateNewTireWorkEntity(NewTireWorkEntity newTireWorkEntity);

	Optional<NewTireWorkEntity> findNewTireWorkEntityById(String id);

	List<NewTireWorkEntity> findAllDataFromNewTireWorkEntity();

	List<NewTireWorkEntity> deleteNewTireWorkEntityById(String id);
	
}
