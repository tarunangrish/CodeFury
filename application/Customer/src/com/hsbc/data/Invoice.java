package com.hsbc.data;


import java.util.Date;

public class Invoice {
	private int invoice_id;
	private Date invoice_date;
	private int order_id;
	private String status;
	private String gst_type;
	private double total_gst_amount;
	private double total_invoice_value;
	
	public Invoice()
	{
		invoice_date=new Date();
	}

	public Invoice(int invoice_id, Date invoice_date, int order_id, String status, String gst_type,
			double total_gst_amount, double total_invoice_value) {
		super();
		this.invoice_id = invoice_id;
		this.invoice_date = invoice_date;
		this.order_id = order_id;
		this.status = status;
		this.gst_type = gst_type;
		this.total_gst_amount = total_gst_amount;
		this.total_invoice_value = total_invoice_value;
	}
	

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public Date getInvoice_date() {
		return invoice_date;
	}

	public void setInvoice_date(Date invoice_date) {
		this.invoice_date = invoice_date;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGst_type() {
		return gst_type;
	}

	public void setGst_type(String gst_type) {
		this.gst_type = gst_type;
	}

	public double getTotal_gst_amount() {
		return total_gst_amount;
	}

	public void setTotal_gst_amount(double total_gst_amount) {
		this.total_gst_amount = total_gst_amount;
	}

	public double getTotal_invoice_value() {
		return total_invoice_value;
	}

	public void setTotal_invoice_value(double total_invoice_value) {
		this.total_invoice_value = total_invoice_value;
	}

	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", invoice_date=" + invoice_date + ", order_id=" + order_id
				+ ", status=" + status + ", gst_type=" + gst_type + ", total_gst_amount=" + total_gst_amount
				+ ", total_invoice_value=" + total_invoice_value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gst_type == null) ? 0 : gst_type.hashCode());
		result = prime * result + ((invoice_date == null) ? 0 : invoice_date.hashCode());
		result = prime * result + invoice_id;
		result = prime * result + order_id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total_gst_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total_invoice_value);
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
		Invoice other = (Invoice) obj;
		if (gst_type == null) {
			if (other.gst_type != null)
				return false;
		} else if (!gst_type.equals(other.gst_type))
			return false;
		if (invoice_date == null) {
			if (other.invoice_date != null)
				return false;
		} else if (!invoice_date.equals(other.invoice_date))
			return false;
		if (invoice_id != other.invoice_id)
			return false;
		if (order_id != other.order_id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(total_gst_amount) != Double.doubleToLongBits(other.total_gst_amount))
			return false;
		if (Double.doubleToLongBits(total_invoice_value) != Double.doubleToLongBits(other.total_invoice_value))
			return false;
		return true;
	}
	

}