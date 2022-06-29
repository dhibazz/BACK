package com.example.gestionrecrutement.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(name = "nomprenom")
	private String nomprenom;


	@Column(name = "username")
	private String username;


	
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;


	 @Column(name = "datenaiss")
	 private Date datenaiss;



     @Column(name = "genre")
	 private String genre;

  
   
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	public User() {
	}
	public User(String nomprenom, String username, String email,String password, Date datenaiss, String genre) {
		this.nomprenom= nomprenom;
		this.username = username;
		this.email = email;
		this.password = password;
		this.datenaiss= datenaiss;
	    this.genre= genre;

	}


	
	public Long getId() {
		return id;
	}

	public String getNomprenom() {
		return nomprenom;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

	public Date getDatenaiss() {
		return datenaiss;
	
	}


	public String getGenre() {
		return genre;
	}

	public Set<Role> getRoles() {
		return roles;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public void setNomprenom(String nomprenom) {
		this.nomprenom = nomprenom;
	}
	public void setusername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void genre(String genre) {
		this.genre = genre;
	}
	

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}