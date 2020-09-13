package com.qa.ims.persistence.domain;

public class Item {
	private Long id;
	private String name;
	private double price;
	
	public Item(String name, Long price) {
		this.setName(name);
		this.setPrice(price);
	}
	public Item(Long id, String name, double price) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", ItemName=" + name + ", price=" + price + "]";
	}
	
	
	
	

}
