package com.hsbc.data;

import java.util.Date;

public class Order {
	private int order_id;
	private Date order_date;
	private String shipping_agency;
	private String status;
	private int customer_id;
	private int company_id;
	private double shipping_cost;
	private double total_order_value;
	
	
	public Order() {
	order_date=new Date();
	}


	public Order(int order_id, Date order_date, String shipping_agency, String status, int customer_id, int company_id,
			double shipping_cost, double total_order_value) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.shipping_agency = shipping_agency;
		this.status = status;
		this.customer_id = customer_id;
		this.company_id = company_id;
		this.shipping_cost = shipping_cost;
		this.total_order_value = total_order_value;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public Date getOrder_date() {
		return order_date;
	}


	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}


	public String getShipping_agency() {
		return shipping_agency;
	}


	public void setShipping_agency(String shipping_agency) {
		this.shipping_agency = shipping_agency;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public int getCompany_id() {
		return company_id;
	}


	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}


	public double getShipping_cost() {
		return shipping_cost;
	}


	public void setShipping_cost(double shipping_cost) {
		this.shipping_cost = shipping_cost;
	}


	public double getTotal_order_value() {
		return total_order_value;
	}


	public void setTotal_order_value(double total_order_value) {
		this.total_order_value = total_order_value;
	}


	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_date=" + order_date + ", shipping_agency=" + shipping_agency
				+ ", status=" + status + ", customer_id=" + customer_id + ", company_id=" + company_id
				+ ", shipping_cost=" + shipping_cost + ", total_order_value=" + total_order_value + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + company_id;
		result = prime * result + customer_id;
		result = prime * result + ((order_date == null) ? 0 : order_date.hashCode());
		result = prime * result + order_id;
		result = prime * result + ((shipping_agency == null) ? 0 : shipping_agency.hashCode());
		long temp;
		temp = Double.doubleToLongBits(shipping_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		temp = Double.doubleToLongBits(total_order_value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (company_id != other.company_id)
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (order_date == null) {
			if (other.order_date != null)
				return false;
		} else if (!order_date.equals(other.order_date))
			return false;
		if (order_id != other.order_id)
			return false;
		if (shipping_agency == null) {
			if (other.shipping_agency != null)
				return false;
		} else if (!shipping_agency.equals(other.shipping_agency))
			return false;
		if (Double.doubleToLongBits(shipping_cost) != Double.doubleToLongBits(other.shipping_cost))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(total_order_value) != Double.doubleToLongBits(other.total_order_value))
			return false;
		return true;
	}
	
	

}