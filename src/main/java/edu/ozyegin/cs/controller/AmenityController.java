package edu.ozyegin.cs.controller;

import java.util.List;
import java.util.Scanner;
import edu.ozyegin.cs.repository.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.ozyegin.cs.entity.Amenity;
import edu.ozyegin.cs.service.AmenityService;


@RestController
@RequestMapping("amenity")
public class AmenityController {
	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	static Scanner scanner3 = new Scanner(System.in);

	@Autowired
	AmenityService service;

	@RequestMapping(path ="/create")
	public boolean createAmenity() {
		System.out.println("Write amenity name");
		String name = scanner.nextLine();
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();
		System.out.println(callerId);
		String value = service.check_role(callerId);

		if(value.equals("Administrator") || value.equals("Receptionist")) {
			return service.createAmenity(name);
		}else {
			return false;
		}
	}
	@RequestMapping("/modify")
	public boolean modifyAmenity() {
		System.out.println("Write amenity name");
		String name = scanner.nextLine();

		System.out.println("Write amenity ID");
		int id = scanner3.nextInt();

		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		System.out.println(callerId);
		String value = service.check_role(callerId);

		if(value.equals("Administrator")) {
			return service.modifyAmenity(name,id);
		}else {
			return false;
		}

	}

	@RequestMapping("/delete")
	public boolean deleteAmenity() {
		System.out.println("Amenity ID");
		int id = scanner.nextInt();
		System.out.println("Write UserID");
		int callerId = scanner2.nextInt();

		String value = service.check_role(callerId);

		if(value.equals("Administrator")) {
			return service.deleteAmenity(id);
		}else {
			return false;
		}

	}

	@GetMapping("/get_all")
	public List<Amenity> getAllAmenity() {
		return service.getAllAmenity();
	}

}
