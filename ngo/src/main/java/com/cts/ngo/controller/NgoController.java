package com.cts.ngo.controller;/*
 *@author Myvin Barboza

 *
 * 12:27 PM 2/27/2020
 */

import com.cts.ngo.model.Ngo;
import com.cts.ngo.repository.NgoRepository;
import com.cts.ngo.service.NgoServiceImpl;
import com.cts.ngo.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class NgoController {
    @GetMapping
    public String getAll(){
        return "I love NGo";
    }

    @Autowired
    NgoServiceImpl ngoService;

    @Autowired
    SecurityTokenGenerator tokenGenerator;
    ///Create
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Ngo ngo){
        try{
            ngoService.saveNgo(ngo);
            return new ResponseEntity<String>("Ngo registered succeesfulty", HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<String>("message"+e.getMessage(),HttpStatus.CONFLICT);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Ngo ngo){
        try {
            String name = ngo.getName();
            String password = ngo.getPassword();
            if(name==null || password==null) {
                throw new Exception("username or passwrd can not be empty");
            }
            Ngo fetchedNgo =ngoService.findByNameAndPassword(name,password);
            if(fetchedNgo==null) {
                throw new Exception("Ngo does not exist");
            }
            if(!password.equals(fetchedNgo.getPassword())) {
                throw new Exception("Sign in failed please check username or password");

            }
            Map<String ,String> map=tokenGenerator.generateToken(fetchedNgo);
            return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<String>("message"+e.getMessage(),HttpStatus.UNAUTHORIZED);
        }
    }

    ///Update
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNgo(@RequestBody Ngo ngo,@PathVariable Integer id){
            try{
                ngoService.updateNgo(ngo,id);
            }catch(Exception e){
                return new ResponseEntity<String>("message"+e.getMessage(),HttpStatus.CONFLICT);
            }

        return new ResponseEntity<String>("Update Successful",HttpStatus.OK);
    }

    ///Delete

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNgo(@PathVariable Integer id){
        try{
            ngoService.deleteNgo(id);
        }catch(Exception e){
            return new ResponseEntity<String>("message"+e.getMessage(),HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>("Delete Successful",HttpStatus.OK);
    }



}
