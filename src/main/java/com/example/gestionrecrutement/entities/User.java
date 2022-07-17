package com.example.gestionrecrutement.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})


public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username")
	private String username;


	@Column(name = "email")
	private String email;
	@Column(name = "nomprenom")
	private String nomprenom;

	@Column(name = "password")
	private String password;


     @OneToMany(mappedBy = "user")
    Set<Candidature> candidatures;

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();



	public User() {
	}
	public User( String username, String email,String password, String nomprenom) {

		this.username = username;
		this.email = email;
		this.password = password;
		this.nomprenom = nomprenom;
	}
}