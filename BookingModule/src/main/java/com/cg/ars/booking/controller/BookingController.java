package com.cg.ars.booking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ars.booking.dto.Booking;
import com.cg.ars.booking.exception.BookingException;
import com.cg.ars.booking.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController
{
	@Autowired
	BookingService service;
	
	@PostMapping("/add")
	public Booking insertBooking(@RequestBody Booking booking)
	{
		return service.insert(booking);
	}
	
	@GetMapping(value="/search/{id}")
    public Booking searchBookingById(@PathVariable("id") String bookingId) throws BookingException
    {
		Booking booking = service.findByBookingId(bookingId);
		
		if (booking == null) {
			throw new BookingException("Booking with [bookingId=" + bookingId + "] not found", "/booking/search/" + bookingId);
		}
		
    	return booking;
    }
	
	@PutMapping(value="/update")
	public Booking updateBooking(@Valid @RequestBody Booking booking)
	{
		return service.save(booking);
	}
	
	@GetMapping(path="/generateBookingId/{airline}")
	public String generateBookingId(@PathVariable("airline") String airline)
	{
		return service.generateBookingId(airline);
	}
}
