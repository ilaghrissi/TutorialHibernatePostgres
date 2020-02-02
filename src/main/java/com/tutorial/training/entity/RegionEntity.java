package com.tutorial.training.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "REGIONS")
@Data
public class RegionEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "REGION_ID")
	private Long regionId;
	
	@Column(name = "REGION_NAME")	
	private String regionName; 
	
	@OneToMany(mappedBy = "region")
	private Set<CountryEntity> countries = new HashSet<>();

}
