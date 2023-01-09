package edu.ozyegin.cs.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UsersController {

	@PostMapping("/create")
	public void createUser(

			String UserName, int UserTypeId, int CallerUserId) {

	}

	@PostMapping("/modify/rename")
	public void renameUser(

			int UserId, String NewName, int CallerUserId) {

	}

}
