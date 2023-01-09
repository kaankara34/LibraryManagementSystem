package edu.ozyegin.cs.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("housekeeping")
public class HouseKeepingController {

	@PostMapping("/schedule")
	public void scheduleRoom(int RoomId, int UserId, int CallerUserId) {

	}

	@PostMapping("/clean")
	public void cleanRoom(int RoomId, int CallerUserId) {

	}

	@PostMapping("/schedule/get")
	public void getRoomsRequiredToClean(int CallerUserId) {

	}

}
