package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Menu;

public interface IMenuRepository extends JpaRepository<Menu,Integer>{
	//search by menu name
	Optional<Menu> findByMname(String mName);

	
}
