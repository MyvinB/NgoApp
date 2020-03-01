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
    public boolean saveRestaurant(Restaurant restaurant) {
        restaurantRespository.save(restaurant);
        return true;
    }

    @Override
    public boolean deleteRestaurant(String id) {
        Restaurant tempRestaurant=restaurantRespository.findById(id);
        restaurantRespository.delete(tempRestaurant);
        return true;
    }

    @Override
    public Restaurant findById(String id) {
       return restaurantRespository.findById(id);

    }

    @Override
    public void changeState(String id) {

        Restaurant object=restaurantRespository.findById(id);
        if(object==null){
            throw new IllegalArgumentException("Didn't find movie in database");
        }
        object.setFood_availability(0);
        restaurantRespository.save(object);

    }

    @Override
    public boolean updateRestaurant(Restaurant restaurant,String id) {
        Restaurant tempRestaurant=restaurantRespository.findById(id);
        tempRestaurant.setName(restaurant.getLocation() == "" ? tempRestaurant.getLocation() : restaurant.getLocation());
        tempRestaurant.setName(restaurant.getName() == "" ? tempRestaurant.getName() : restaurant.getName());
        tempRestaurant.setFood_availability(restaurant.getFood_availability()==0?tempRestaurant.getFood_availability():restaurant.getFood_availability());
        restaurantRespository.save(tempRestaurant);
        return true;
    }
}
