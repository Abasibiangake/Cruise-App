package com.microservice.one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	//property
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bookingid")
	private int bookingId;
	@Column(name="custid")
	private int CustId;
	@Column(name="cruiseid")
	private int CruiseId;
	@Column(name="numberofguest")
	private Integer NumberOfGuests;
	@Column(name="totalamount")
	private double TotalAmount;
	@Column(name="status")
	private String Status;
	
	//overloaded constructor with no parameters
	public Booking() {
		super();
	}

	//constructor with 6 parameters
	public Booking( int custId, int cruiseId, Integer numberOfGuests, double totalPrice, String status) {
		super();
		CustId = custId;
		CruiseId = cruiseId;
		NumberOfGuests = numberOfGuests;
		TotalAmount = totalPrice;
		Status = status;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getCustId() {
		return CustId;
	}
	public void setCustId(int custId) {
		CustId = custId;
	}
	public int getCruiseId() {
		return CruiseId;
	}
	public void setCruiseId(int cruiseId) {
		CruiseId = cruiseId;
	}
	public Integer getNumberOfGuests() {
		return NumberOfGuests;
	}
	public void setNumberOfGuests(Integer numberOfGuests) {
		NumberOfGuests = numberOfGuests;
	}
	public double getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
}
