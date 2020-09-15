package com.qa.ims.persistence.domain;

public class Order {
	private Long orderid;
	private Long fkcid;
	private Long fkpid;
	private String DOP;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DOP == null) ? 0 : DOP.hashCode());
		result = prime * result + ((fkcid == null) ? 0 : fkcid.hashCode());
		result = prime * result + ((fkpid == null) ? 0 : fkpid.hashCode());
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
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
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		return true;
	}
	
	
}
