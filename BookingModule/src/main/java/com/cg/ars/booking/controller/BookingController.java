package com.cg.ars.booking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ars.booking.dto.Booking;
import com.cg.ars.booking.exception.BookingException;
import com.cg.ars.booking.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController
{
	@Autowired
	BookingService B_SER;
	
	@PostMapping("/add")
	public Booking insertBooking(@RequestBody Booking booking)
	{
		System.out.println(booking);
		return B_SER.insert(booking);
	}
	
	@GetMapping(value="/search/{id}")
    public Booking searchBookingById(@PathVariable("id") String bookingId) throws BookingException
    {
		Booking booking = B_SER.findByBookingId(bookingId);
		
		if (booking == null) {
			throw new BookingException("Booking with [bookingId=" + bookingId + "] not found", "/booking/search/" + bookingId);
		}
		
    	return booking;
    }
	
	@PutMapping(value="/update")
	public Booking updateBooking(@Valid @RequestBody Booking booking)
	{
		return B_SER.save(booking);
	}
	
	@GetMapping(path="/generateBookingId/{flightNo}")
	public String generateBookingId(@PathVariable("flightNo") String flightNo)
	{
		return B_SER.generateBookingId(flightNo);
	}
}
