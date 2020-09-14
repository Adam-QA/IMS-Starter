package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item>{
	public static final Logger LOGGER = LogManager.getFormatterLogger();
	private ItemDAO itemDAO;
	private Utils utils;
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for(Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("Enter the item's name");
		String name = utils.getString();
		LOGGER.info("Enter the price of the item");
		double price = utils.getDouble();
		Item item = itemDAO.create(new Item(name, price));
		LOGGER.info("Item added to the system");
		return item;
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the pid of the item you would like to update");
		Long pid = utils.getLong();
		LOGGER.info("Please enter the item name");
		String name = utils.getString();
		LOGGER.info("Please enter the item price");
		double price = utils.getDouble();
		Item item = itemDAO.update(new Item(pid, name, price));
		LOGGER.info("Item Updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the pid of the item you would like to delete");
		Long pid = utils.getLong();
		return itemDAO.delete(pid);
	}
	

}
