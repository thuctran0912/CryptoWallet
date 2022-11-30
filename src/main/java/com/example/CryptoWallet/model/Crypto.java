package com.example.CryptoWallet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Crypto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name, code, dateBought;
	private double boughtPrice, quantity;
	
	public Crypto() {
	}
	
	public Crypto(String name, String code, String dateBought, double boughtPrice, double quantity) {
		super();
		this.name = name;
		this.code = code;
		this.dateBought = dateBought;
		this.boughtPrice = boughtPrice;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDateBought() {
		return dateBought;
	}

	public void setDateBought(String dateBought) {
		this.dateBought = dateBought;
	}

	public double getBoughtPrice() {
		return boughtPrice;
	}

	public void setBoughtPrice(double boughtPrice) {
		this.boughtPrice = boughtPrice;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Crypto [id=" + id + ", name=" + name + ", code=" + code + ", dateBought=" + dateBought
				+ ", boughtPrice=" + boughtPrice + ", quantity=" + quantity + "]";
	}
	
	
}
