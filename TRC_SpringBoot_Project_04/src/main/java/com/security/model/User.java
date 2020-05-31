package com.security.model;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.assertj.core.util.Arrays;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
		

	private int active ;
	 
	private String roles ;
	
	private String permissions ;

	public User() {
	}

	public User(String username, String password, int active, String roles, String permissions) {
		this.username = username;
		this.password = password;
		this.active = 1;
		this.roles = roles;
		this.permissions = permissions;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
 
	public List<String> getRoleList() {
		if(this.roles.length() > 0 ) {
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<>();
	}
	
}
