package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Menu;
import com.app.exceptions.MenuNotFoundException;
import com.app.repository.IMenuRepository;

@Service
@Transactional
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private IMenuRepository dao;
	
	@Override
	public List<Menu> getAllMenus() {
		System.out.println("dao impl class "+getClass().getName());
		return dao.findAll();
	}

	@Override
	public Optional<Menu> getMenuDetails(Integer mId) {
		// TODO Auto-generated method stub
		return dao.findById(mId);
	}

	@Override
	public Menu addMenuDetails(Menu transientPOJO) {
		// TODO Auto-generated method stub
		return dao.save(transientPOJO);
	}

	@Override
	public Menu updateMenuDetails(int menuId, Menu m1) {
		
		Optional<Menu> m = dao.findById(menuId);
		if(m.isPresent())
		{
			
			Menu menu = m.get();
			menu.setMname(m1.getMname());
			menu.setImage(m1.getImage());
			menu.setDescription(m1.getDescription());
			menu.setMenu_category(m1.getMenu_category());
			menu.setPrice(m1.getPrice());
			return menu;
		}
		
		throw new MenuNotFoundException("Invalid Menu ID");
	}

	@Override
	public Optional<Menu> findById(int mid) {
		// TODO Auto-generated method stub
		return dao.findById(mid);
	}

	@Override
	public void deleteById(int mid) {
		// TODO Auto-generated method stub
		dao.deleteById(mid);
		
	}
}
