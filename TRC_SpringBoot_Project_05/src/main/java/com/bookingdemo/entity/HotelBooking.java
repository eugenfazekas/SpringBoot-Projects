package com.bookingdemo.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelBooking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String hotelName;
	private double pricePerNight;
	private int numberOfNights;

	public HotelBooking() {
	
	}

	public HotelBooking(String hotelName, double pricePerNight, int numberOfNights) {
		this.hotelName = hotelName;
		this.pricePerNight = pricePerNight;
		this.numberOfNights = numberOfNights;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public int getNumberOfNights() {
		return numberOfNights;
	}
	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}
	 public double getTotalPrice(){
	        return pricePerNight * numberOfNights;
	 }
}
