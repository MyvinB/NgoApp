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

    public void changeState(int id);

}
