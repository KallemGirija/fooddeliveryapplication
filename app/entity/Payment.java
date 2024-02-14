package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_table")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private String pay_id;			
	
	@Column(length = 16)
	private String cardNumber;
	
	@Column(length = 60)
	private String cardHolder;
	
	@Column(length = 60)
	private String expiryDate;
	
	@Column(length = 3)
	private String cvv;
	
	
	@Column(length = 6)
	private Boolean order_status=false;
	
		
	public Payment() {
		System.out.println("in ctor of "+getClass().getName());
	}


	public Payment(String pay_id, String cardNumber, String cardHolder, String expiryDate, String cvv,
			Boolean order_status) {
		super();
		this.pay_id = pay_id;
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.order_status = order_status;
	}


	public String getPay_id() {
		return pay_id;
	}


	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getCardHolder() {
		return cardHolder;
	}


	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public Boolean getOrder_status() {
		return order_status;
	}


	public void setOrder_status(Boolean order_status) {
		this.order_status = order_status;
	}


	@Override
	public String toString() {
		return "Payment [pay_id=" + pay_id + ", cardNumber=" + cardNumber + ", cardHolder=" + cardHolder
				+ ", expiryDate=" + expiryDate + ", cvv=" + cvv + ", order_status=" + order_status + "]";
	}


}
