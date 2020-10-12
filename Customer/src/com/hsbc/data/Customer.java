package com.hsbc.data;



public class Customer {
	
	private int customer_id;
	private String customer_first_name;
	private String customer_middle_name;
	private String customer_last_name;
	private int customer_street_number;
	private String customer_street_name;
	private String customer_city;
	private String customer_state;
	private String customer_pincode;
	private String customer_email_id;
	
	public Customer()
	{
		
	}

	public Customer(int customer_id, String customer_first_name, String customer_middle_name, String customer_last_name,
			int customer_street_number, String customer_street_name, String customer_city, String customer_state,
			String customer_pincode, String customer_email_id) {
		super();
		this.customer_id = customer_id;
		this.customer_first_name = customer_first_name;
		this.customer_middle_name = customer_middle_name;
		this.customer_last_name = customer_last_name;
		this.customer_street_number = customer_street_number;
		this.customer_street_name = customer_street_name;
		this.customer_city = customer_city;
		this.customer_state = customer_state;
		this.customer_pincode = customer_pincode;
		this.customer_email_id = customer_email_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_first_name() {
		return customer_first_name;
	}

	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}

	public String getCustomer_middle_name() {
		return customer_middle_name;
	}

	public void setCustomer_middle_name(String customer_middle_name) {
		this.customer_middle_name = customer_middle_name;
	}

	public String getCustomer_last_name() {
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}

	public int getCustomer_street_number() {
		return customer_street_number;
	}

	public void setCustomer_street_number(int customer_street_number) {
		this.customer_street_number = customer_street_number;
	}

	public String getCustomer_street_name() {
		return customer_street_name;
	}

	public void setCustomer_street_name(String customer_street_name) {
		this.customer_street_name = customer_street_name;
	}

	public String getCustomer_city() {
		return customer_city;
	}

	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}

	public String getCustomer_state() {
		return customer_state;
	}

	public void setCustomer_state(String customer_state) {
		this.customer_state = customer_state;
	}

	public String getCustomer_pincode() {
		return customer_pincode;
	}

	public void setCustomer_pincode(String customer_pincode) {
		this.customer_pincode = customer_pincode;
	}

	public String getCustomer_email_id() {
		return customer_email_id;
	}

	public void setCustomer_email_id(String customer_email_id) {
		this.customer_email_id = customer_email_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customer_id;
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
		Customer other = (Customer) obj;
		if (customer_id != other.customer_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_first_name=" + customer_first_name
				+ ", customer_middle_name=" + customer_middle_name + ", customer_last_name=" + customer_last_name
				+ ", customer_street_number=" + customer_street_number + ", customer_street_name="
				+ customer_street_name + ", customer_city=" + customer_city + ", customer_state=" + customer_state
				+ ", customer_pincode=" + customer_pincode + ", customer_email_id=" + customer_email_id + "]";
	}
	
	

}
