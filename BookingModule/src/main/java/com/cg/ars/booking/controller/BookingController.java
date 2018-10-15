package com.cg.ars.booking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	BookingService B_SER;
	
	@PostMapping(value="/add",consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Booking insertBooking(@Valid @RequestBody Booking booking){
		return B_SER.save(booking);
		
	}
	
	@GetMapping(value="/search/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Booking searchBookingById(@PathVariable("id")String bookingId) throws BookingException
    {
		Booking booking = B_SER.findByBookingId(bookingId);
		if(booking == null)
		{
			throw new BookingException("Booking Id:["+bookingId+"] not found","/booking/searchBooking");
		}
    	return booking;
    }
}
