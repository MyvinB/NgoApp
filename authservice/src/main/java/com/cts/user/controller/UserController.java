package com.cts.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cts.user.domain.User;
import com.cts.user.services.SecurityTokenGenerator;
import com.cts.user.services.UserService;

@RestController

@CrossOrigin
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityTokenGenerator tokenGenerator;
	
	
	@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
		try{
			userService.saveUser(user);
			return new ResponseEntity<String>("User registered succeesfulty",HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("message"+e.getMessage(),HttpStatus.CONFLICT);
		}
	}

	@GetMapping
	public String check(){
		return "User service is up";
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user){
		try {
			String userId = user.getUserId();
			String password = user.getPassword();
			if(userId==null || password==null) {
				throw new Exception("username or passwrd can not be empty");
			}
			User fetchedUser = userService.findByUserIdAndPassword(userId, password);
			if(fetchedUser==null) {
				throw new Exception("User does not exist");
			}
			if(!password.equals(fetchedUser.getPassword())) {
				throw new Exception("Sign in failed please check username or password");
				
			}
			Map<String ,String> map=tokenGenerator.generateToken(fetchedUser);
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);				
		}catch(Exception e) {
			return new ResponseEntity<String>("message"+e.getMessage(),HttpStatus.UNAUTHORIZED);
		}
	}
}
