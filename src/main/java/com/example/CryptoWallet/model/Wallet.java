package com.example.CryptoWallet.model;

public class Wallet {
	private String name;
	private String code;
	private double quantity;
	private double avgPrice;
	
	public Wallet(String name, String code, double quantity, double avgPrice) {
		this.name = name;
		this.code = code;
		this.quantity = quantity;
		this.avgPrice = avgPrice;
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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	@Override
	public String toString() {
		return "Wallet [name=" + name + ", code=" + code + ", quantity=" + quantity + ", avgPrice=" + avgPrice + "]";
	}


	
	
}
