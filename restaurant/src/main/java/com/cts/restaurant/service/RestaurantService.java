package com.cts.restaurant.service;/*
 *@author Myvin Barboza

 *
 * 10:42 AM 2/27/2020
 */

import com.cts.restaurant.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RestaurantService {

    public List<Restaurant> getAllRestaurant();
    public boolean saveRestaurant(Restaurant restaurant);
    public boolean deleteRestaurant(String id);
    public Restaurant findById(String id);
    public void changeState(String id);
    public boolean updateRestaurant(Restaurant restaurant,String userId);

}
