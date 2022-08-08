package com.movie.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "movie")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "added")
	private Timestamp added;

	@Column(name = "external_id")
	private String externalId;
	
	public Movie() {

	}

	public Movie(String title,Timestamp timestamp, String externalId) {
		this.title = title;
		this.added = timestamp;
		this.externalId = externalId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getAdded() {
		return added;
	}

	public void setAdded(Timestamp added) {
		this.added = added;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", added=");
		builder.append(added);
		builder.append(", externalId=");
		builder.append(externalId);
		builder.append("]");
		return builder.toString();
	}

}
