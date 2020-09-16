package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.OrderDAO;

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
		LOGGER.info("Please enter the Customer Id");
		Long fkcid = utils.getLong();
		LOGGER.info("Please enter the Product Id");
		Long fkpid = utils.getLong();
		LOGGER.info("Please enter the date of your purchase");
		String DOP = utils.getString();
		Order order = orderDAO.create(new Order(fkcid, fkpid, DOP));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the new Order id");
		Long orderid = utils.getLong();
		LOGGER.info("Please enter the new Customer Id");
		Long fkcid = utils.getLong();
		LOGGER.info("Please enter the new Product Id");
		Long fkpid = utils.getLong();
		LOGGER.info("Please enter the new date of your purchase");
		String DOB = utils.getString();
		Order order = orderDAO.update(new Order(orderid, fkcid, fkpid, DOB));
		LOGGER.info("Order Updated");
		return order;
	}
	
	public Order add() {
		LOGGER.info("Please enter the new Order id");
		Long orderid = utils.getLong();
		LOGGER.info("Please enter the new Customer Id");
		Long fkcid = utils.getLong();
		LOGGER.info("Please enter the new Product Id");
		Long fkpid = utils.getLong();
		LOGGER.info("Please enter the new date of your purchase");
		String DOB = utils.getString();
		Order order = orderDAO.update(new Order(orderid, fkcid, fkpid, DOB));
		LOGGER.info("Order Updated");
		return order;
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