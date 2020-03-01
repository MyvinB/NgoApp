package com.cts.ngo.controller;/*
 *@author Myvin Barboza

 *
 * 12:27 PM 2/27/2020
 */

import com.cts.ngo.model.Ngo;
import com.cts.ngo.service.NgoServiceImpl;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@CrossOrigin
public class NgoController {
    @GetMapping
    public String getAll(){
        return "ngo is good";
    }

    @Autowired
    NgoServiceImpl ngoService;

    //To get USERID from request
    static String getUser(HttpServletRequest request){
        final String authHeader = request.getHeader("authorization");
        final String token = authHeader.substring(7);
        String user= Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
        String s[]=user.split("-");
       return s[0];
    }
    //create Ngo
    @PostMapping
    public ResponseEntity<?> createNgo(HttpServletRequest request,@RequestBody Ngo ngo){
        String userId=getUser(request);
        ngo.setId(userId);
        try{
            ngoService.saveNgo(ngo);
        }catch(Exception e){
            return new ResponseEntity<String>("message"+e.getMessage(),HttpStatus.CONFLICT);
        }

        return new ResponseEntity<String>("Save Successful",HttpStatus.OK);
    }

    ///Update
    @PutMapping
    public ResponseEntity<?> updateNgo(HttpServletRequest request,@RequestBody Ngo ngo){
        String id=getUser(request);
        try{
                ngoService.updateNgo(ngo,id);
            }catch(Exception e){
                return new ResponseEntity<String>("message"+e.getMessage(),HttpStatus.CONFLICT);
            }

        return new ResponseEntity<String>("Update Successful",HttpStatus.OK);
    }

    ///Delete
    @DeleteMapping
    public ResponseEntity<?> deleteNgo(HttpServletRequest request){
        String id=getUser(request);
        try{
            ngoService.deleteNgo(id);
        }catch(Exception e){
            return new ResponseEntity<String>("message"+e.getMessage(),HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>("Delete Successful",HttpStatus.OK);
    }

    //get Ngo
    @GetMapping("getNgo")
    public ResponseEntity<?> getNgo(HttpServletRequest request){
        String id=getUser(request);
        try{

            return new ResponseEntity<Ngo>( ngoService.getNgo(id)   ,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>("message"+e.getMessage(),HttpStatus.CONFLICT);
        }

    }


}
