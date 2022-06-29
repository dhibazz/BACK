package com.example.gestionrecrutement.payload.request;
import java.sql.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



public class SignupRequest {

  @NotBlank
  private String nomprenom;

  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Email
  private String email;


  @NotBlank
  private String password;

  @NotBlank
  private Date datenaiss;

  @NotBlank
  private String genre;

  private Set<String> role;



  public String getNomprenom() {
    return null;
}

public void setNomprenom(String nomprenom) {
  this.nomprenom = nomprenom;
}


  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

 
  public Date getDatenaiss() {
    return datenaiss;
  }


  public void setDatenaiss(Date datenaiss) {
    this.datenaiss = datenaiss;
  }

  public String getGenre() {
    return null;

}


public void setGenre(String genre) {
  this.genre = genre;
}



  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  
  };






}