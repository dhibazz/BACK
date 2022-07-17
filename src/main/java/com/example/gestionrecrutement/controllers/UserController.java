package com.example.gestionrecrutement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionrecrutement.entities.User;
import com.example.gestionrecrutement.services.UserService;

@RestController //il s'agit d'une api rest
@RequestMapping("/api/User") // pathe global o ki n3aytou fi postman n7otou pathe global+getmapping
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
	UserService userService;
	
    
   @RequestMapping(value="/getAllUsers" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<User>> getAllUsers(){
    List<User> users=userService.getAllUsers();
     return new ResponseEntity<List<User>>(HttpStatus.OK);
    }
}
