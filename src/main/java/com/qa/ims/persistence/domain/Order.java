package com.qa.ims.persistence.domain;

public class Order {
	private Long orderid;
	private Long fkcid;
	private Long fkpid;
	private String DOP;
	private Long orderlid;
	private String customername;
	private String itemname;
	private Double price;
	private Double total;
	
	
	
	public Order(Long orderlid, Long orderid, String customername, String itemname, Double price, Double total, String DOP) {
		this.setOrderlid(orderlid);
		this.setOrderid(orderid);
		this.setCustomername(customername);
		this.setItemname(itemname);
		this.setPrice(price);
		this.setTotal(total);
		this.setDOP(DOP);
		
		
	}
	public Order(Long orderid, Long fkcid, Long fkpid, String DOP) {
		this.setOrderid(orderid);
		this.setFkcid(fkcid);
		this.setDOP(DOP);
		this.setFkpid(fkpid);
	}

	public Order(Long fkcid, Long fkpid, String DOP) {
		this.setFkpid(fkpid);
		this.setFkcid(fkcid);
		this.setDOP(DOP);
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	public Long getOrderlid() {
		return orderlid;
	}
	public void setOrderlid(Long orderlid) {
		this.orderlid = orderlid;
	}
	
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public Long getFkcid() {
		return fkcid;
	}
	public void setFkcid(Long fkcid) {
		this.fkcid = fkcid;
	}
	public Long getFkpid() {
		return fkpid;
	}
	public void setFkpid(Long fkpid) {
		this.fkpid = fkpid;
	}
	public String getDOP() {
		return DOP;
	}
	public void setDOP(String dOP) {
		DOP = dOP;
	}

	@Override
	public String toString() {
		return "Order [Order Id = " + orderid + ", Customer Id = " + fkcid + ", Product Id = " + fkpid + ", Date Of Purchase = " + DOP + "]";
	}
	public String printString() {
		return "Order [Orderline_id = " + orderlid + ", Order Id = " + orderid + ", Customer Name = " + customername + ", Item Name = " + itemname + ", + Item Price = " + price + ", Total Cost = " + total + ", Date Of Purchase = " + DOP + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DOP == null) ? 0 : DOP.hashCode());
		result = prime * result + ((customername == null) ? 0 : customername.hashCode());
		result = prime * result + ((fkcid == null) ? 0 : fkcid.hashCode());
		result = prime * result + ((fkpid == null) ? 0 : fkpid.hashCode());
		result = prime * result + ((itemname == null) ? 0 : itemname.hashCode());
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((orderlid == null) ? 0 : orderlid.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (DOP == null) {
			if (other.DOP != null)
				return false;
		} else if (!DOP.equals(other.DOP))
			return false;
		if (customername == null) {
			if (other.customername != null)
				return false;
		} else if (!customername.equals(other.customername))
			return false;
		if (fkcid == null) {
			if (other.fkcid != null)
				return false;
		} else if (!fkcid.equals(other.fkcid))
			return false;
		if (fkpid == null) {
			if (other.fkpid != null)
				return false;
		} else if (!fkpid.equals(other.fkpid))
			return false;
		if (itemname == null) {
			if (other.itemname != null)
				return false;
		} else if (!itemname.equals(other.itemname))
			return false;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		if (orderlid == null) {
			if (other.orderlid != null)
				return false;
		} else if (!orderlid.equals(other.orderlid))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	

	
	
	
}
