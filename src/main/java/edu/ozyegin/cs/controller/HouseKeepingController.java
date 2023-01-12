package edu.ozyegin.cs.controller;

import java.util.List;
import java.util.Scanner;
import edu.ozyegin.cs.repository.HouseKeepingRepository;
import edu.ozyegin.cs.service.AmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.ozyegin.cs.entity.*;
import edu.ozyegin.cs.service.HouseKeepingService;

@RestController
@RequestMapping("housekeeping")
public class HouseKeepingController {

	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	static Scanner scanner3 = new Scanner(System.in);


	@Autowired
	HouseKeepingService service;

	@RequestMapping("/schedule")
	public boolean scheduleRoom() {
		System.out.println("Write room id");
		int id = scanner.nextInt();

		System.out.println("Write amenity ID");
		int id2 = scanner3.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		System.out.println(callerId);
		String value = service.check_role(callerId);

		if(value.equals("Administrator")) {
			return service.scheduleRoom(id,id2);
		}else {
			return false;
		}
	}

	@RequestMapping("/clean")
	public boolean cleanRoom() {
		System.out.println("Room ID");
		int id = scanner.nextInt();
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();
		System.out.println(callerId);
		String value = service.check_role(callerId);

		if(value.equals("Administrator")) {
			return service.cleanRoom(id);
		}else {
			return false;
		}
	}

	@RequestMapping("/schedule/get")
	public int[] getRoomsRequiredToClean(int CallerUserId) {
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();
		String value = service.check_role(callerId);

		if(value.equals("Administrator")) {
			return service.getRoomsRequiredToClean();
		}else {
			return new int[0];
		}
	}

}
