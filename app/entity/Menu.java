package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="menu_table")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer menu_id;
	
	@Column(length = 60)
	@NotBlank(message = "Name must be supplied")
	private String mname;
	
	@Column
	private String image;
	
	@Column(length = 60)
	private String description;
		
	@Column(length = 50)
	private String menu_category;
	
	@Min(10)
	private float price;
	
	
			
	
	
	public Menu() {
		System.out.println("in ctor of "+getClass().getName());
	}
	
	public Menu(Integer menu_id, String mname,String image, String description,
			Integer quantity, String menu_category, @Min(50) float price) {
		super();
		this.menu_id = menu_id;
		this.mname = mname;
		this.image = image;
		this.description = description;	
		this.menu_category = menu_category;
		this.price = price;
	}

	
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
	public String getMenu_category() {
		return menu_category;
	}
	public void setMenu_category(String menu_category) {
		this.menu_category = menu_category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", mname=" + mname + ", image=" + image + ", description=" + description
				+ ", menuCategory=" + menu_category + ", price=" + price + "]";
	}	
}
