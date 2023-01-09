package edu.ozyegin.cs.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("statistics")
public class StatisticsController {

	@PostMapping("/room/bookings")
	public void getNoOfBookings(int RoomId, int CallerUserId) {

	}

	@PostMapping("/room/bookings/conversion_rate")
	public void getConversionRate(int RoomId, int CallerUserId) {

	}

	@PostMapping("/room/average_price")
	public void getAveragePrice(int RoomId, int CallerUserId) {

	}

	@PostMapping("/room/max_user_bookings")
	public void getMaxUserBookings(int RoomId, int CallerUserId) {

	}

	@PostMapping("/room/max_user_duration")
	public void getMaxUserDuration(int RoomId, int CallerUserId) {

	}

	@PostMapping("/room/amenity_count")
	public void getAmenityCount(int RoomId, int K, int CallerUserId) {

	}

	@PostMapping("/housekeeping/count_clean")
	public void getCleanedCount(

			int CallerUserId) {

	}

	@PostMapping("/housekeeping/max_unique")
	public void getMostCleaningHouseKeeper(

			int CallerUserId) {

	}

	@PostMapping("/housekeeping/max_unfinished")
	public void getMostPendingHouseKeeper(

			int CallerUserId) {

	}

	@PostMapping("/housekeeping/with_most_housekeepers")
	public void getRoomWithMostHouseKeepers(

			int CallerUserId) {

	}

	@PostMapping("/bookings/price/amenity")
	public void getAvePriceOfRoomsWithAtLeastKAmenities(

			int CallerUserId, int K) {

	}

	@PostMapping("/bookings/max_room/price")
	public void getAvePriceOfRoomsWithHighestBookingWithAtLeastTDays(

			int CallerUserId, int T) {

	}

	@PostMapping("/amenity/max")
	public void getIdOfMostComAmenities(

			int CallerUserId) {

	}

	@PostMapping("/amenity/difference")
	public void getAmenitiyDifference(

			int CallerUserId) {

	}

}
