package com.cts.restaurant.repository;/*
 *@author Myvin Barboza

 *
 * 10:40 AM 2/27/2020
 */

import com.cts.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRespository extends JpaRepository<Restaurant,Integer> {
public Restaurant findById(int id);

@Query(nativeQuery =true,value = "SELECT * FROM Restaurant as e WHERE e.food_availability=1")
public List<Restaurant> getListRestaurants();
}
