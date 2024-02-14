package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ResponseDTO;
import com.app.entity.Restaurant;
import com.app.service.IRestaurantService;

@RestController
@RequestMapping("/res")
@CrossOrigin(origins ="http://localhost:4200")
public class RestaurantController {
	
	@Autowired
	private IRestaurantService service;
	
	public RestaurantController() {		
		System.out.println("in ctor of "+getClass().getName());
	}
	//RESTFul end point or API end point or API provider 
	@GetMapping("/all")
	public ResponseEntity<?> listAllRestaurants()
	{
		System.out.println("in list of all Restaurants");
		//invoke service layer's method : controller --> service impl (p) --> JPA's repo's impl class(SC)
		List<Restaurant> res = service.getAllRestaurants();
		if(res.isEmpty()) {
			//empty product list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(new ResponseDTO("error","Restaurant List has no contents." ,null),HttpStatus.NO_CONTENT); 
		}
		//in case of non empty list : OK, send the list
		return new ResponseEntity<>(new ResponseDTO("success", "List of All Restaurants", res), HttpStatus.OK);		
	}
	//get menu details by its id : supplied by clnt using path var
	@GetMapping("/{details}")
	public ResponseEntity<?> getRestaurantDetails(@PathVariable Integer details)
	{
		System.out.println("in get prod details "+details);
		Optional<Restaurant> resDetails = service.getRestaurantDetails(details);
		//in case of invalid name : HTTP 404
		if(resDetails.isPresent())
			return new ResponseEntity<>(new ResponseDTO("success", "Get restaurant details by Restaurant ID", resDetails.get()), HttpStatus.OK);
		//valid name : HTTP 200, marshalled restaurant details
		return new ResponseEntity<>(new ResponseDTO("error","Menu details not Found BY ID"+ details ,null),HttpStatus.NOT_FOUND);
	}
	//req handling method to create a new product : post
	@PostMapping("/add")
	public ResponseEntity<?> addRestaurant(@RequestBody Restaurant r)
	{
		System.out.println("in add restaurant "+r);
		try {
			Restaurant savedRestaurant = service.addRestaurantDetails(r);
			return new ResponseEntity<>(new ResponseDTO("success", "Addition of New Restaurant", savedRestaurant), HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ResponseDTO("error","Restaurant addition failed." ,null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//req handling method to update existing product
	@PutMapping("/{resId}")
	public ResponseEntity<?> updateRestaurantDetails(@PathVariable int resId, @RequestBody Restaurant r)
	{
		System.out.println("in update "+resId+" "+r);
		try {
			Restaurant updatedDetails = service.updateRestaurantDetails(resId, r);
			return new ResponseEntity<>(new ResponseDTO("success", "Restaurant Updated successfully", updatedDetails),HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ResponseDTO("error","Restaurant Updation Failed." ,null),HttpStatus.NOT_FOUND);
		}
		
	}
	//req handling method to delete existing menu
	@DeleteMapping("/{rid}")
	public ResponseEntity<?> deleteRestaurant(@PathVariable int rid)
	{
		System.out.println("in del menu "+rid);
		// check if user exists
		Optional<Restaurant> optional = service.findById(rid);
		if (optional.isPresent()) {
			service.deleteById(rid);
			return new ResponseEntity<>(new ResponseDTO("success","Restaurant deleted with ID " + rid,null), HttpStatus.OK);
		} else
			return new ResponseEntity<>(new ResponseDTO("error","Restaurant deletion failed" ,null), HttpStatus.NOT_ACCEPTABLE);		
	}



}
