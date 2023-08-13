package com.example.demo;



public interface UserService {
    String addUser(User DTO);
 
    LoginMessage loginUser(LoginDTO loginDTO);
 
}