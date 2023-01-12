package edu.ozyegin.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ozyegin.cs.entity.Rooms;
import edu.ozyegin.cs.repository.RoomsRepository;

@Service
public class RoomService {

    @Autowired
    RoomsRepository repository;

    public boolean createRoom(String roomName, int roomTypeId) {
        return repository.createRoom(roomName,roomTypeId);
    }

    public String check_role(int callerId) {
            return repository.check_role(callerId);
        }

    public boolean renameRoom(String name, int id) {
        return repository.renameRoom(name,id);
    }

    public boolean changeRoomType(int id, int typeid) {
        return repository.changeRoomType(id,typeid);
    }

    public boolean deleteRoom(int id) {
        return repository.deleteRoom(id);
    }

    public boolean addAmenityInRoom(int roomid, int amenityId) {
        return repository.addAmenityInRoom(roomid,amenityId);
    }

    public boolean removeAmenityFromRoom(int roomid, int amenityId) {
        return repository.removeAmenityFromRoom(roomid,amenityId);
    }

    public List<Rooms> getAllRooms() {
        return repository.getAllRooms();
    }

    public List<Rooms> get_available_for_date(String d1, String d2) {
        return repository.get_available_for_date(d1,d2);
    }

}
