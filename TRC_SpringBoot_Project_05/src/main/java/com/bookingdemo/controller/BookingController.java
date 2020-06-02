package com.bookingdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingdemo.entity.HotelBooking;

@RestController
@RequestMapping(value = "bookings")
public class BookingController {

	private List<HotelBooking> bookings;

	public BookingController() {
		
		bookings = new ArrayList<>();
		
		bookings.add(new HotelBooking("Marriot",200.50,3));
		bookings.add(new HotelBooking("Ibis",90,4));
		bookings.add(new HotelBooking("Novotel",140.74,1));
	}
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public List<HotelBooking> getAll() {
		return bookings;
	}
	
	@RequestMapping(value = "affordable/{price}", method = RequestMethod.GET)
	public List<HotelBooking> getAffordable(@PathVariable double price){
		return bookings.stream().filter(x -> x.getPricePerNight() <= price)
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public List<HotelBooking> create (@RequestBody HotelBooking hotelBooking){
		
		bookings.add(hotelBooking);
		
		return bookings;
	}
	
}
