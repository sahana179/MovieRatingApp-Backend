package com.movie.model;

public class AuthenticatedUser {
	private long id;

	private String username;

	private String role;

	public AuthenticatedUser() {

	}

	public AuthenticatedUser(long id, String username, String role) {
		this.id = id;
		this.username = username;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
