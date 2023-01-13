package com.mng.bridgestone.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;



import lombok.Data;



@Entity
@Data
@SQLDelete(sql = "UPDATE new_tire_work_entity SET active_switch = true WHERE id=?")
@Where(clause = "active_switch = false")
public class NewTireWorkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dev_sql")
	@GenericGenerator(name = "dev_sql", strategy = "com.mng.bridgestone.util.StringPrefixedSequenceGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
			@org.hibernate.annotations.Parameter(name = "valuePrefix", value = "bs_"),
			@org.hibernate.annotations.Parameter(name = "numberFormat", value = "%05d") })
	private String id;
	private String barcodeNumber;
	private String employeeId;
	private String shift;
//	@Enumerated(EnumType.STRING)
//	@Column(length = 20)
//	private DefectType defectType;
	private ArrayList<String> defect;
	private String createdBy;
	@Column(name = "createDateTime", nullable = false, updatable = false)
	@CreationTimestamp()
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	private boolean active_switch = Boolean.FALSE;

}
