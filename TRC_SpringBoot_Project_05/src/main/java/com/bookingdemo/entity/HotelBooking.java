package com.bookingdemo.entity;

public class HotelBooking {

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
