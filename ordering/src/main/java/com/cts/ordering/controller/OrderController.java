package com.cts.ordering.controller;

import com.cts.ordering.service.OrderService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/*
 @author Myvin Barboza
 01/03/20 1:53 AM 
 */
@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;


    static String getUser(HttpServletRequest request){
        final String authHeader = request.getHeader("authorization");
        final String token = authHeader.substring(7);
        String user= Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
        String s[]=user.split("-");
        return s[0];
    }

    @GetMapping
    public String check(){
        return "Order Service is up";
    }

    @PostMapping("/saveOrder/{ngo}/{restaurant}")
    public ResponseEntity<?> saveOrder(HttpServletRequest request,
                                      @PathVariable String ngo,@PathVariable String restaurant){
        String id=getUser(request);
        System.out.println(id +" "+ngo+"  "+restaurant);
        try{
            orderService.saveOrder(id,ngo,restaurant);
            return new ResponseEntity<String>("Succesful saved Order", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
}