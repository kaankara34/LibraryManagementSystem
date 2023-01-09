package edu.ozyegin.cs.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booking")
public class BookingController {
	
	@PostMapping("/make_booking")
	public void makeBooking(
			
			int UserId,
			Date DayStart,
			Date DayEnd,
			double Price,
			int CallerUserId) {
		
		
	}
	@PostMapping("/cancel_booking")
	public void cancelBooking(
			
			int BookingId,
			int CallerUserId) {
		
		
	}
	@PostMapping("/modify/change_date")
	public void changeBookingDate(
			
			int BookingId,
			Date DayStart,
			Date DayEnd,
			int CallerUserId) {
		
		
	}
	@PostMapping("/modify/change_price")
	public void changePrice(
			
			int BookingId,
			double NewPrice,
			int CallerUserId) {
		
		
	}
	@PostMapping("/get")
	public void getInfoOfBooking(
			
			int BookingId,
			
			int CallerUserId) {
		
		
	}
	@PostMapping("/get_all")
	public void getAllBookings(
			) {
		
		
	}
	@PostMapping("/pay")
	public void payBooking(
			
			int BookingId,
			
			int CallerUserId) {
		
		
	}
	@PostMapping("/check_in")
	public void checkIn(
			
			int BookingId,
			
			int CallerUserId,
			String Date) {
		
		
	}
	@PostMapping("/check_out")
	public void checkOut(
			
			int BookingId,
			
			int CallerUserId,
			String Date) {
		
		
	}

}
