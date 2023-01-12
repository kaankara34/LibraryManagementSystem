package edu.ozyegin.cs.controller;

import java.util.List;
import java.util.Scanner;
import edu.ozyegin.cs.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.ozyegin.cs.entity.*;
import edu.ozyegin.cs.service.StatisticsService;


@RestController
@RequestMapping("statistics")
public class StatisticsController {

	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	static Scanner scanner3 = new Scanner(System.in);
	@Autowired
	StatisticsService service;

	@PostMapping("/room/bookings")
	public int getNoOfBookings() {
		System.out.println("Write RoomId");
		int RoomId = scanner.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.getNoOfBookings(RoomId);
		}else {
			return 1;
		}
	}

	@PostMapping("/room/bookings/conversion_rate")
	public double getConversionRate() {
		System.out.println("Write RoomId");
		int RoomId = scanner.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.getConversionRate(RoomId);
		}else {
			return 1.0;
		}
	}

	@PostMapping("/room/average_price")
	public float getAveragePrice() {
		System.out.println("Write RoomId");
		int RoomId = scanner.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.getAveragePrice(RoomId);
		}else {
			return 1.0f;
		}

	}

	@PostMapping("/room/max_user_bookings")
	public int getMaxUserBookings() {
		System.out.println("Write RoomId");
		int RoomId = scanner.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.getMaxUserBookings(RoomId);
		}else {
			return 1;
		}
	}

	@PostMapping("/room/max_user_duration")
	public int getMaxUserDuration() {
		System.out.println("Write RoomId");
		int RoomId = scanner.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.getMaxUserDuration(RoomId);
		}else {
			return 1;
		}

	}

	@PostMapping("/room/amenity_count")
	public List<Amenity> getAmenityCount() {
		System.out.println("Write RoomId");
		int RoomId = scanner.nextInt();

		System.out.println("Write K");
		int k = scanner3.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.getAmenityCount(RoomId,k);
		}else {
			return null;
		}
	}

	@PostMapping("/housekeeping/count_clean")
	public int getCleanedCount(int CallerUserId) {
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.getCleanedCount();
		}else {
			return 0;
		}
	}

	@PostMapping("/housekeeping/max_unique")
	public int getMostCleaningHouseKeeper(int CallerUserId) {
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.getMostCleaningHouseKeeper();
		}else {
			return 0;
		}

	}

	@PostMapping("/housekeeping/max_unfinished")
	public int getMostPendingHouseKeeper(int CallerUserId) {
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.getMostPendingHouseKeeper();
		}else {
			return 0;
		}

	}

	@PostMapping("/housekeeping/with_most_housekeepers")
	public int[] getRoomWithMostHouseKeepers(int CallerUserId) {
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.getRoomWithMostHouseKeepers();
		}else {
			return new int[0];
		}
	}

	@PostMapping("/bookings/price/amenity")
	public double getAvePriceOfRoomsWithAtLeastKAmenities() {
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		System.out.println("Write RoomId");
		int k = scanner.nextInt();

		String value = service.check_role(callerId);
		if(value.equals("Administrator") || value.equals("Receptionist")) {

			return service.getAvePriceOfRoomsWithAtLeastKAmenities(k);
		}else {
			return 1;
		}
	}

	@PostMapping("/bookings/max_room/price")
	public double getAvePriceOfRoomsWithHighestBookingWithAtLeastTDays() {
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		System.out.println("Write RoomId");
		int t = scanner.nextInt();

		String value = service.check_role(callerId);
		if(value.equals("Administrator") || value.equals("Receptionist")) {

			return service.getAvePriceOfRoomsWithHighestBookingWithAtLeastTDays(t);
		}else {
			return 1;
		}
	}

	@PostMapping("/amenity/max")
	public int[] getIdOfMostComAmenities() {
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.getIdOfMostComAmenities();
		}else {
			return null;
		}

	}

	@PostMapping("/amenity/difference")
	public double getAmenitiyDifference() {
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if (value.equals("Administrator") || value.equals("Receptionist") || value.equals("Guest")) {
			return service.getAmenitiyDifference();
		} else {
			return 1;
		}
	}
}
