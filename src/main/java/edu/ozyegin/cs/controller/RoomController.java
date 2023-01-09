package edu.ozyegin.cs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("room")
public class RoomController {

	@PostMapping("/create")
	public void createRoom(

			String RoomName, int RoomTypeId, int CallerUserId) {

	}

	@PostMapping("/modify/rename")
	public void renameRoom(int RoomId, String NewName, int CallerUserId) {

	}

	@PostMapping("/modify/change_type")
	public void changeRoomType(int RoomId, int RoomTypeId, int CallerUserId) {

	}

	@PostMapping("/modify/delete")
	public void deleteRoom(

			int RoomId, int CallerUSerId) {

	}

	@PostMapping("/amenity/add")
	public void addAmenityInRoom(int RoomId, int AmenityId, int CallerUserId) {

	}

	@PostMapping("/amenity/remove")
	public void removeAmenityFromRoom(int RoomId, int AmenityId, int CallerUserId) {

	}

	@GetMapping("/get_all")
	public void getAllRooms() {

	}

	@PostMapping("/get_available_for_date")
	public void removeAmenityFromRoom(String StartDate, String EndDate) {

	}

}
