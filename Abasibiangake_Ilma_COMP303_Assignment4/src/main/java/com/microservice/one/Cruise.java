package com.microservice.one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cruise")
public class Cruise {
	//property
	@Id
	@Column(name="cruiseid")
	private int cruiseId;
	
	@Column(name="cruisename")
	private String CruiseName;
	
	@Column(name="departuredate")
	private String DepartureDate;
	
	@Column(name="duration")
	private int Duration;
	
	@Column(name="price")
	private double Price;
	
	//overloaded constructor with no parameters
	public Cruise() {
		super();
	}

	//constructor with 5 parameters
	public Cruise(int cruiseId, String cruiseName, String departureDate, int duration, double price) {
		super();
		this.cruiseId = cruiseId;
		CruiseName = cruiseName;
		DepartureDate = departureDate;
		Duration = duration;
		Price = price;
	}

	//getters and setters
	public int getCruiseId() {
		return cruiseId;
	}

	public void setCruiseId(int cruiseId) {
		this.cruiseId = cruiseId;
	}

	public String getCruiseName() {
		return CruiseName;
	}

	public void setCruiseName(String cruiseName) {
		CruiseName = cruiseName;
	}

	public String getDepartureDate() {
		return DepartureDate;
	}

	public void setDepartureDate(String departureDate) {
		DepartureDate = departureDate;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Cruise [cruiseId=" + cruiseId + ", CruiseName=" + CruiseName + ", DepartureDate=" + DepartureDate
				+ ", Duration=" + Duration + ", Price=" + Price + "]";
	}
	

}
