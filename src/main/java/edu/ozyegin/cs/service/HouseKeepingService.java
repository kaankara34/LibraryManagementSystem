package edu.ozyegin.cs.service;

import java.util.List;

import edu.ozyegin.cs.repository.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ozyegin.cs.entity.*;
import edu.ozyegin.cs.repository.HouseKeepingRepository;

@Service
public class HouseKeepingService {


    @Autowired
    HouseKeepingRepository repository;

    public boolean scheduleRoom(int roomId, int userId) {
        return repository.scheduleRoom(roomId,userId);
    }

    public boolean cleanRoom(int roomId) {
        return repository.cleanRoom(roomId);
    }

    public int[] getRoomsRequiredToClean() {
        return repository.getRoomsRequiredToClean();
    }

    public String check_role(int callerId) {
        return repository.check_role(callerId);
    }
}