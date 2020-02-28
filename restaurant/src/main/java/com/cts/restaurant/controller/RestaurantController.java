package com.cts.restaurant.controller;/*
 *@author Myvin Barboza

 *
 * 10:44 AM 2/27/2020
 */

import com.cts.restaurant.filter.JwtFilter;
import com.cts.restaurant.model.Restaurant;
import com.cts.restaurant.service.RestaurantService;
import com.cts.restaurant.service.RestaurantServiceImpl;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class RestaurantController {

//    @Bean
//    public FilterRegistrationBean jwtFilter() {
//        final FilterRegistrationBean registerBean = new FilterRegistrationBean();
//        registerBean.setFilter(new JwtFilter());
//        registerBean.addUrlPatterns("/*");
//        return registerBean;
//    }

    @Autowired
    RestaurantServiceImpl restaurantService;

    @GetMapping
    public String getAll(){
        return "I love 65..";
    }
    @GetMapping("/getAllRestaurant")
    public ResponseEntity<?> getAllRestaurant(HttpServletRequest request,
                                              HttpServletResponse response){


        try {
            return new ResponseEntity<List<Restaurant>>(restaurantService.getAllRestaurant(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/changeState/{id}")
    public ResponseEntity<?> changeStatus(@PathVariable("id") int id){
        try {
            restaurantService.changeState(id);
            return new ResponseEntity<String>("Succesful changed state", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
