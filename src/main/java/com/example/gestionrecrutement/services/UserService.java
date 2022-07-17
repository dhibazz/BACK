package com.example.gestionrecrutement.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionrecrutement.entities.User;
import com.example.gestionrecrutement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        System.out.println(new Date());
        return   userRepository.findAll();
    }
    
}
