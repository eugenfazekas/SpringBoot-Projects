package com.bookingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingdemo.entity.HotelBooking;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository <HotelBooking, Long> {
	
    List<HotelBooking> findByPricePerNightLessThan(double price);
}
