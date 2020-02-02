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
@Table(name = "LOCATIONS")
@Data
public class LocationEntity {

	@Id
	@GeneratedValue
	@Column(name = "LOCATION_ID")
	private Long locationId;
	
	@Column(name = "STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name = "POSTAL_CODE") 
	private String postalCode;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE_PROVINCE")
	private String stateProvince;
	
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	private CountryEntity country;
	
	@OneToMany(mappedBy = "location")
	private Set<DepartmentEntity> departments = new HashSet<>();
}
