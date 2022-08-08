package com.movie.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "country")
	private String country;

	@Column(name = "area")
	private String area;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "number")
	private String number;
	
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="contact_id", nullable=true) private Contact contact;
	 */

	public Address() {

	}

	public Address(String country, String area, String city, String street, String number) {
		super();
		this.country = country;
		this.area = area;
		this.city = city;
		this.street = street;
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
