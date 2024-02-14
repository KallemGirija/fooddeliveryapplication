package com.app.dto;

import com.app.entity.Cart;
import com.app.entity.Menu;

public class MenuCartDTO {
	private Menu menu;
	private Cart cart;
	
	
	public MenuCartDTO() {
		super();
	}

	public MenuCartDTO(Menu menu, Cart cart) {
		super();
		this.menu = menu;
		this.cart = cart;
	}

	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
