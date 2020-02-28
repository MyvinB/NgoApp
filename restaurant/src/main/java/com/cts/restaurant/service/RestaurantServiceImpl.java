package com.cts.restaurant.service;/*
 *@author Myvin Barboza

 *
 * 10:43 AM 2/27/2020
 */

import com.cts.restaurant.model.Restaurant;
import com.cts.restaurant.repository.RestaurantRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRespository restaurantRespository;

    public List<Restaurant> getAllRestaurant(){
        return restaurantRespository.getListRestaurants();
    }

    @Override
    public void changeState(int id) {

        Restaurant object=restaurantRespository.findById(id);
        if(object==null){
            throw new IllegalArgumentException("Didn't find movie in database");
        }
        object.setFood_availability(0);
        restaurantRespository.save(object);

    }
}
