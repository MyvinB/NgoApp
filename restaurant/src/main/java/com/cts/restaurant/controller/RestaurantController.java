package com.cts.restaurant.controller;/*
 *@author Myvin Barboza

 *
 * 10:44 AM 2/27/2020
 */

import com.cts.restaurant.filter.JwtFilter;
import com.cts.restaurant.model.Restaurant;
import com.cts.restaurant.service.RestaurantService;
import com.cts.restaurant.service.RestaurantServiceImpl;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
public class RestaurantController {



    @Autowired
    RestaurantServiceImpl restaurantService;

    static String getUser(HttpServletRequest request){
        final String authHeader = request.getHeader("authorization");
        final String token = authHeader.substring(7);
        String user= Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
        String s[]=user.split("-");
        return s[0];
    }

    @GetMapping
    public String getAll(){
        return "I love 65..";
    }

//    @GetMapping("/fault-tolerance")
//    @HystrixCommand(fallbackMethod = "getAll")
//    public String faultcheck(){
//        throw new  RuntimeException("Check is getAll is called");
//    }

    @GetMapping("/getAllRestaurant")
    public ResponseEntity<?> getAllRestaurant(){

        try {
            return new ResponseEntity<List<Restaurant>>(restaurantService.getAllRestaurant(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getRestaurant")
    public ResponseEntity<?> getRestaurant(HttpServletRequest request){
        String userId=getUser(request);
        try {
            return new ResponseEntity<Restaurant>(restaurantService.findById(userId), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/changeState/{id}")
    public ResponseEntity<?> changeStatus(HttpServletRequest request,@PathVariable String id){

        try {
            restaurantService.changeState(id    );
            return new ResponseEntity<String>("Succesful changed state", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    //create
    @PostMapping
    public ResponseEntity<?> createRestaurant(HttpServletRequest request ,@RequestBody Restaurant restaurant){
        String userId=getUser(request);
        restaurant.setId(userId);
        try {
            restaurantService.saveRestaurant(restaurant);
            return new ResponseEntity<String>("Succesful saved Restaurant", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //delete
    @DeleteMapping
    public ResponseEntity<?> deleteRestaurant(HttpServletRequest request){
        String userId=getUser(request);
        try {
            restaurantService.deleteRestaurant(userId);
            return new ResponseEntity<String>("Delete Restaurant Succesful", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    //update
    @PutMapping("/updateRestaurant")
    public ResponseEntity<?> updateRestaurant(HttpServletRequest request ,@RequestBody Restaurant restaurant){
        String userId=getUser(request);
        try {
            restaurantService.updateRestaurant(restaurant,userId);
            return new ResponseEntity<String>("Updated changes in Restaurant", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
