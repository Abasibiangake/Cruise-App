package com.microservice.two.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Document(collection="cruise_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Cruise {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	@Id
	private long cruiseId;
	private String cruiseDestination;
	private String cruiseLine;
    @NotBlank(message = "Departure date is mandatory")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate departureDate;
	private String visitingPlaces;
	private String duration;
	private int price;
	
	
	
	
	public Cruise(int cruiseId, String cruiseDestination, String cruiseLine, LocalDate departureDate,
			String visitingPlaces, String duration, int price) {
		super();
		this.cruiseId = cruiseId;
		this.cruiseDestination = cruiseDestination;
		this.cruiseLine = cruiseLine;
		this.departureDate = departureDate;
		this.visitingPlaces = visitingPlaces;
		this.duration = duration;
		this.price = price;
	}


	public Cruise() {
		super();
	}
	
	
	public long getCruiseId() {
		return cruiseId;
	}


	public void setCruiseId(long cruiseId) {
		this.cruiseId = cruiseId;
	}


	public String getCruiseDestination() {
		return cruiseDestination;
	}


	public void setCruiseDestination(String cruiseDestination) {
		this.cruiseDestination = cruiseDestination;
	}


	public String getCruiseLine() {
		return cruiseLine;
	}


	public void setCruiseLine(String cruiseLine) {
		this.cruiseLine = cruiseLine;
	}


	public LocalDate getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}


	public String getVisitingPlaces() {
		return visitingPlaces;
	}


	public void setVisitingPlaces(String visitingPlaces) {
		this.visitingPlaces = visitingPlaces;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}



}
