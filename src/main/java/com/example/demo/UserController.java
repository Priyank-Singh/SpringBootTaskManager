package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
 
 
    @Autowired
    private UserService userService;
	
//    @Value("${cors.allowed-origins}")
//	private String allowedOrigins;
    
//    
    @PostMapping(path = "/save")
    public String saveUser(@RequestBody User dto)
    {
        String id = userService.addUser(dto);
        return id;
    }
 
//    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login")
    public ResponseEntity<LoginMessage>loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}