package com.cg.ars.booking.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.ars.booking.dto.Booking;

public interface BookingService extends MongoRepository<Booking, String> {

	public Booking  findByBookingId(String bookingId);

}
