package com.example.gestionrecrutement.payload.request;
import java.sql.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class SignupRequest {

  

  @NotBlank
  @Size(min = 3, max = 20)
  private String username;


  @NotBlank
  @Email
  private String email;


  @NotBlank
  private String nomprenom;
  @NotBlank
  private String password;



  private Set<String> role;



 





}