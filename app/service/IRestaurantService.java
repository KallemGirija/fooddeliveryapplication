package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.Restaurant;

public interface IRestaurantService {
	
	// list all Restaurant
	List<Restaurant> getAllRestaurants();
	//get Restaurant by name
	Optional<Restaurant> getRestaurantDetails(Integer rId);
	//add new Restaurant details
	Restaurant addRestaurantDetails(Restaurant transientPOJO);
	//update Restaurant details
	Restaurant updateRestaurantDetails(int resId,Restaurant detachedPOJO);
	//delete existing details
	Optional<Restaurant> findById(int rid);
	void deleteById(int rid);


}
