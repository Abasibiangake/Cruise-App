package com.microservice.one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	//properties
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="custid")
	private int CustId;
	
	@Column(name="firstname")
	private String FirstName;
	
	@Column(name="lastname")
	private String LastName;
	
	@Column(name="address")
	private String Address;
	
	@Column(name="city")
	private String City;
	
	@Column(name="country")
	private String Country;
	
	@Column(name="phone")
	private long Phone;
	
	private String email;

	private String password;
	
	//overloaded constructor with no parameters
	public Customer() {
		super();
	}
	//overloaded constructor with 8 parameters
	public Customer(int custId, String firstName, String lastName, String address, String city, String country,
			long phone, String email, String password) {
		super();
		CustId = custId;
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		City = city;
		Country = country;
		Phone = phone;
		this.email = email;
		this.password = password;
	}
	//overloaded constructor with 7 parameters
	public Customer(String firstName, String lastName, String address, String city, String country,
			long phone, String email, String password) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		City = city;
		Country = country;
		Phone = phone;
		this.email = email;
		this.password = password;
	}

	//getters and setters
	public int getCustId() {
		return CustId;
	}

	public void setCustId(int custId) {
		CustId = custId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public long getPhone() {
		return Phone;
	}

	public void setPhone(long phone) {
		Phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
