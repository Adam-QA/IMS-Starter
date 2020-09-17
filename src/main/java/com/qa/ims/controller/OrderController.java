package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Would you like to create an order or add to an order");
		String answer = utils.getString();
		switch(answer) {
		case "create":
			LOGGER.info("Please enter the Customer Id");
			Long customerId = utils.getLong();
			Order order = orderDAO.create(new Order(new Customer(customerId, null, null)));
			LOGGER.info("Order created");
			return order;
		case "add":
			LOGGER.info("Please enter your order ID");
			Long oid = utils.getLong();
			LOGGER.info("Please enter the ID of the product you would like to add");
			Long pid = utils.getLong();
			Order orderadd = orderDAO.create(oid, pid);
			LOGGER.info("Item added to order");
			return orderadd;
		default:
			LOGGER.info("Invalid input");
			break;
		}
		return null;
		
	
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Order update() {
		//TODO: change this to take in a orderid, then change the customerid of that order and return it
		// (if you can be bothered - NJ)
//		LOGGER.info("Please enter the new Order Id");
//		Long orderid = utils.getLong();
//		LOGGER.info("Please enter the new Customer Id");
//		Long fkcid = utils.getLong();
//		LOGGER.info("Please enter the new Product Id");
//		Long fkpid = utils.getLong();
//		LOGGER.info("Please enter the new date of your purchase");
//		String DOB = utils.getString();
//		Order order = orderDAO.update(new Order(orderid, fkcid, fkpid, DOB));
//		LOGGER.info("Order Updated");
		return null;
	}
	


	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please select what you would like to delete, an order or an item?");
		String answer = utils.getString();
		switch(answer) {
		case "order":
			LOGGER.info("Please enter the order id of the order you would like to delete");
			Long orderid = utils.getLong();
			return orderDAO.delete(orderid);
		case "item":
			LOGGER.info("Please enter your order ID");
			Long oid = utils.getLong();
			LOGGER.info("Please enter the product ID of the item you wish to delete");
			Long pid = utils.getLong();
			return orderDAO.delete(oid,pid);
		default:
			LOGGER.info("Invalid input");
			break;
		}
		return 0;
		
		
	}

}