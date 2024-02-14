package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="restaurant_table")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer res_id;
	
	@Column(length = 60)
	@NotBlank(message = "Name must be supplied")
	private String rname;
	
	@Column(length = 300)
	private String res_address;
	
	@Min(0)@Max(5)
	private Integer rating;
	
	public Restaurant() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Restaurant(Integer res_id, @NotBlank(message = "Name must be supplied") String rname, String res_address,
			@Min(0) @Max(5) Integer rating) {
		super();
		this.res_id = res_id;
		this.rname = rname;
		this.res_address = res_address;
		this.rating = rating;
	}

	public Integer getRes_id() {
		return res_id;
	}

	public void setRes_id(Integer res_id) {
		this.res_id = res_id;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRes_address() {
		return res_address;
	}

	public void setRes_address(String res_address) {
		this.res_address = res_address;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Restaurant [res_id=" + res_id + ", rname=" + rname + ", res_address=" + res_address + ", rating="
				+ rating + "]";
	}
	
	
	




}
