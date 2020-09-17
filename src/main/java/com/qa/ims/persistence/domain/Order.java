package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private Long orderid;
	private Customer customer;
	private String customerfullname;
	private List<Item> items = new ArrayList<>();
	private String item;
	private double price;
	private Long customerid;
	
	
	public Order(Long orderid, Customer customer, List<Item> items) {
		super();
		this.orderid = orderid;
		this.customer = customer;
		this.items = items;
	}
	public Order(Long customerid) {
		this.customerid = customerid;
	}


	public Order(Customer customer, List<Item> items) {
		super();
		this.customer = customer;
		this.items = items;
	}
	
	public Order(Customer customer) {
		super();
		this.customer = customer;
	}
	public Order(Long id, String customer, String item, double price) {
		super();
		this.orderid = id;
		this.customerfullname = customer;
		this.item = item;
		this.price = price;
	}
	public Long getCusId() {
		return customerid;
	}


	public Long getOrderid() {
		return orderid;
	}


	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", customer=" + customerfullname +", item=" + item
				+ ", price=" + price + "]";
	}


	
	
	
	
	

	

		
}
