package edu.ozyegin.cs.controller;

import java.util.List;
import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.ozyegin.cs.entity.Rooms;
import edu.ozyegin.cs.service.RoomService;


@RestController
@RequestMapping("room")
public class RoomController {

	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	static Scanner scanner3 = new Scanner(System.in);


	@Autowired
	RoomService service;

	@RequestMapping("/create")
	public boolean createRoom() {
		System.out.println("room name");
		String name = scanner.nextLine();

		System.out.println("roomtypeid ");
		int no = scanner2.nextInt();

		System.out.println("callerid ");
		int callerId = scanner3.nextInt();


		String value = service.check_role(callerId);

		if(value.equals("Administrator")) {
			return service.createRoom(name,no);
		}else {
			return false;
		}

	}

	@RequestMapping("/modify/rename")
	public boolean renameRoom() {
		System.out.println("room name");
		String name = scanner.nextLine();

		System.out.println("room type id");
		int id = scanner2.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner3.nextInt();


		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.renameRoom(name,id);
		}else {
			return false;
		}
	}

	@RequestMapping("/modify/change_type")
	public boolean changeRoomType() {
		System.out.println("room id");
		int id = scanner.nextInt();

		System.out.println("room type id");
		int typeid = scanner2.nextInt();

		System.out.println("caller id");
		int callerId = scanner3.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.changeRoomType(id,typeid);
		}else {
			return false;
		}
	}

	@RequestMapping("/modify/delete")
	public boolean deleteRoom() {
		System.out.println("RoomId");
		int id = scanner.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator")) {
			return service.deleteRoom(id);
		}else {
			return false;
		}
	}

	@RequestMapping("/amenity/add")
	public boolean addAmenityInRoom() {
		System.out.println("roomid");
		int roomid = scanner.nextInt();

		System.out.println("amenity");
		int amenityId = scanner2.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner3.nextInt();

		String value = service.check_role(callerId);
		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.addAmenityInRoom(roomid,amenityId);
		}else {
			return false;
		}
	}

	@RequestMapping("/amenity/remove")
	public boolean removeAmenityFromRoom() {
		System.out.println("roomid");
		int roomid = scanner.nextInt();

		System.out.println("amenity");
		int amenityId = scanner2.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner3.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.removeAmenityFromRoom(roomid,amenityId);
		}else {
			return false;
		}
	}

	@GetMapping("/get_all")
	public List<Rooms> getAllRooms() {
		return service.getAllRooms();
	}

	@RequestMapping("/get_available_for_date")
	public Object get_available_for_date() {
		System.out.println("date1");
		String d1 = scanner.nextLine();

		System.out.println("date2");
		String d2 = scanner2.nextLine();

		System.out.println("Write UserID");
		int callerId = scanner3.nextInt();

		String value = service.check_role(callerId);
		if (value.equals("Administrator") || value.equals("Receptionist") || value.equals("Guest")) {
			return service.get_available_for_date(d1, d2);
		}else{
			return "You dont have access";
		}
	}

}
