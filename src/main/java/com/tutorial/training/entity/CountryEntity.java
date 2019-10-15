package com.tutorial.training.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "COUNTRIES")
@Data
public class CountryEntity {

	@Id
	@GeneratedValue
	@Column(name = "COUNTRY_ID")
	private Long countryId;
	
	@Column(name = "COUNTRY_NAME")
	private String countryName;
	
	@OneToMany(mappedBy = "country")
	private Set<LocationEntity> locations = new HashSet<LocationEntity>();
	
	@ManyToOne
	@JoinColumn(name = "REGION_ID")
	private RegionEntity region;
}
