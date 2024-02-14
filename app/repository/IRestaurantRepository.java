package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Restaurant;


public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer>{

	Optional<Restaurant> findByRname(String rName);

}
