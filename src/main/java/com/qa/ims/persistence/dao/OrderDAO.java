package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	private CustomerDAO customerDao;
	private ItemDAO itemDao;
	
	public OrderDAO(CustomerDAO customerDao, ItemDAO itemDao) {
		super();
		this.customerDao = customerDao;
		this.itemDao = itemDao;
	}

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderid = resultSet.getLong("order_id");
		Customer customer = customerDao.readCustomer(resultSet.getLong("fk_cid"));
		List<Item> items = getItems(orderid);
		return new Order(orderid, customer, items);
	}

	public Order modelOne(ResultSet resultSet) throws SQLException {
		Long orderid = resultSet.getLong("order_id");
		String customer = resultSet.getString("Customer Name");
		//Item itemsId = itemDao.readItem(resultSet.getLong("fk_pid"));
		String item = resultSet.getString("item_name");
		Double price = resultSet.getDouble("price");
		return new Order(orderid, customer, item, price);
	}

	private List<Item> getItems(Long orderid) {
		List<Long> itemIds = new ArrayList<>();
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders, orderline where orders.order_id =" + orderid + " orderline.order_id=" + orderid);){
			while (resultSet.next()) {
				itemIds.add(resultSet.getLong("fk_pid"));
			}
		} catch(SQLException e) {
			LOGGER.debug(e);
			LOGGER.debug(e.getMessage());
		}
		return itemIds.stream().map(this.itemDao::readItem).collect(Collectors.toList());
	}

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select orders.order_id, concat(customers.first_name, \" \", customers.surname) as \"Customer Name\", "
						+ "items.item_name, items.price from orders, orderline, items, customers where orders.order_id = "
						+ "orderline.order_id and orderline.fk_pid= items.pid and orders.fk_cid = customers.id;");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelOne(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orders(`fk_cid`) values(" + order.getCustomer().getId() + ")");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	public Order create(Long oid, Long pid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO orderline (`order_id`, `fk_pid`) VALUES (?, ?)")) {
			statement.setLong(1,  oid);
			statement.setLong(2, pid);
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order readOrder(Long orderid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where order_id = " + orderid);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a customer in the database
	 * 
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	@Override
	public Order update(Order order) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("update orders set fk_cid ='" + order.getFkcid() + "', fk_pid ='"
//					+ order.getFkpid() + "' where order_id =" + order.getOrderid());
//			return readOrder(order.getOrderid());
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public int delete(long orderid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from orders where order_id = " + orderid);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	public int delete(Long oid, Long pid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
	             Statement statement = connection.createStatement();) {
	            return statement.executeUpdate("delete from orderline where order_id in (select order_id from orders where order_id = "+ oid +
	                    " and fk_pid = "+pid+ ")");
	        } catch (Exception e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
	        return 0;
		
	}
	
	
	

}
