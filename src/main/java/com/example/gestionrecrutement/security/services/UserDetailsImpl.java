package com.example.gestionrecrutement.security.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.gestionrecrutement.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String username;
  private String nomprenom;
  private String email;
  
  @JsonIgnore
  private String password;

  private Date datenaiss; 
  private String genre;



  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(Long id, String nomprenom, String username, String email, String password, Date datenaiss, String genre,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.nomprenom=nomprenom;
    this.username = username;
    this.email = email;
    this.password = password;
    this.datenaiss=datenaiss;
    this.genre=genre;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(), 
        user.getUsername(), 
        user.getNomprenom(),
        user.getEmail(),
        user.getPassword(), 
        user.getDatenaiss(),
        user.getGenre(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
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



  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
} 