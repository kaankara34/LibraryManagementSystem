package edu.ozyegin.cs.controller;

import java.util.List;
import java.util.Scanner;


import edu.ozyegin.cs.repository.UsersRepository;
import edu.ozyegin.cs.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.ozyegin.cs.entity.Users;
import edu.ozyegin.cs.service.UsersService;


@RestController
@RequestMapping("user")
public class UsersController {

	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	static Scanner scanner3 = new Scanner(System.in);

	@Autowired
	UsersService service;

	@PostMapping("/create")
	public boolean createUser() {
		System.out.println("Write user name");
		String name = scanner.nextLine();

		System.out.println("typeID");
		int typeid = scanner2.nextInt();

		System.out.println("callerID");
		int callerId = scanner3.nextInt();

		System.out.println(callerId);
		String value = service.check_role(callerId);

		if(value.equals("Administrator")) {
			return service.createUser(name,typeid);
		}else {
			return false;
		}
	}

	@PostMapping("/modify/rename")
	public boolean renameUser() {
		System.out.println("userId");
		int userId = scanner2.nextInt();

		System.out.println("Write user name");
		String name = scanner.nextLine();

		System.out.println("callerID");
		int callerId = scanner3.nextInt();

		System.out.println(callerId);
		String value = service.check_role(callerId);

		if(value.equals("Administrator")) {
			return service.renameUser(userId,name);
		}else {
			return false;
		}
	}
}
