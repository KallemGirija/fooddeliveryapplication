package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Restaurant;
import com.app.exceptions.RestaurantNotFoundException;
import com.app.repository.IRestaurantRepository;

@Service
@Transactional
public class RestaurantServiceImpl implements IRestaurantService{
	
	@Autowired
	private IRestaurantRepository rdao;
	
	@Override
	public List<Restaurant> getAllRestaurants() {
		System.out.println("dao impl class "+getClass().getName());
		return rdao.findAll();
	}

	@Override
	public Optional<Restaurant> getRestaurantDetails(Integer rId) {
		// TODO Auto-generated method stub
		return rdao.findById(rId);
	}

	@Override
	public Restaurant addRestaurantDetails(Restaurant transientPOJO) {
		// TODO Auto-generated method stub
		return rdao.save(transientPOJO);
	}

	@Override
	public Restaurant updateRestaurantDetails(int resId, Restaurant r1) {
		// chk if product exists
		Optional<Restaurant> r = rdao.findById(resId);
		if(r.isPresent())
		{
			//m.get() : PERSISTENT
			//p1 : detached POJO : contains the updates sent by clnt
			//change the state of persistent POJO
			Restaurant res = r.get();
			res.setRname(r1.getRname());
			res.setRes_address(r1.getRes_address());
			res.setRating(r1.getRating());
			return res;
		}
		//in case of no menu found : throw custom exception
		throw new RestaurantNotFoundException("Invalid Menu ID");
	}

	@Override
	public Optional<Restaurant> findById(int rid) {
		// TODO Auto-generated method stub
		return rdao.findById(rid);
	}

	@Override
	public void deleteById(int rid) {
		// TODO Auto-generated method stub
		rdao.deleteById(rid);
		
	}


}
