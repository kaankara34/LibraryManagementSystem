package edu.ozyegin.cs.repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import edu.ozyegin.cs.entity.Rooms;
import edu.ozyegin.cs.entity.RoomsAmenities;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoomsRepository {
    @PersistenceContext

    private EntityManager entityManager;


    public String check_role (int callerUserId){
        Query query = entityManager.createNativeQuery("SELECT userTypeName\n" +
                "FROM userType \n" +
                "JOIN users\n" +
                "ON userType.userTypeID = users.userTypeID\n" +
                "WHERE users.userID ="+callerUserId+"\n");
        List<String> resultString = query.getResultList();
        String value = resultString.get(0);
        return value;
    }
    @Transactional
    @Modifying
    public boolean createRoom(String roomName, int roomTypeId) {
        entityManager.createNativeQuery("INSERT INTO rooms (room_name,roomTypeID) VALUES ("+roomName+","+roomTypeId+")").executeUpdate();
        return true;
    }
    @Transactional
    @Modifying
    public boolean changeRoomType(int id, int typeid){
        entityManager.createNativeQuery("UPDATE rooms SET roomTypeID ="+typeid+"WHERE roomID ="+id+";").executeUpdate();
        return true;
    }
    @Transactional
    @Modifying
    public boolean deleteRoom(int id) {
        entityManager.createNativeQuery("DELETE FROM rooms WHERE roomID ="+id+";").executeUpdate();
        return true;
    }
    @Transactional
    @Modifying
    public boolean addAmenityInRoom(int roomid, int amenityId) {
        entityManager.createNativeQuery("INSERT INTO roomsAmenities (roomID,amenityID) VALUES ("+roomid+","+ amenityId+");").executeUpdate();
        return true;
    }
    @Transactional
    @Modifying
    public boolean removeAmenityFromRoom(int roomid, int amenityId) {
        entityManager.createNativeQuery("DELETE FROM roomsAmenities WHERE roomID="+roomid+" AND amenityID="+amenityId+";").executeUpdate();
        return true;
    }
    public List<Rooms> getAllRooms() {
        Query query = entityManager.createNativeQuery("SELECT * FROM rooms");
        List<Rooms> resultlist = query.getResultList();
        return resultlist;
    }
    public List<Rooms> get_available_for_date(String d1, String d2) {
        Query query = entityManager.createNativeQuery("SELECT room.* FROM rooms as room\n" +
                "LEFT JOIN booking ON room.roomID = booking.roomID \n" +
                "WHERE booking.roomID IS NULL OR \n" +
                "(booking.start_date NOT BETWEEN"+d1+"AND"+d2+"AND booking.end_date NOT BETWEEN"+d1+" AND"+d2+")");
        List<Rooms> resultlist = query.getResultList();
        return resultlist;
    }
    @Transactional
    @Modifying
    public boolean renameRoom(String name, int id) {
        entityManager.createNativeQuery("UPDATE rooms SET room_name ="+name +"WHERE roomID ="+id+";").executeUpdate();
        return true;
    }
}
