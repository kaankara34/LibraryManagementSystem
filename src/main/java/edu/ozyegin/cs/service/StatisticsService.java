package edu.ozyegin.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ozyegin.cs.entity.*;
import edu.ozyegin.cs.repository.StatisticsRepository;

@Service
public class StatisticsService {

    @Autowired
    StatisticsRepository repository;

    public  String check_role(int callerId){
        return repository.check_role(callerId);
    }
    public int getNoOfBookings(int roomId) {
        return repository.getNoOfBookings(roomId);
    }

    public double getConversionRate(int roomId) {
        return repository.getConversionRate(roomId);
    }

    public float getAveragePrice(int roomId) {
        return repository.getAveragePrice( roomId);
    }

    public int getMaxUserBookings(int roomId) {
        return repository.getMaxUserBookings( roomId);
    }

    public int getMaxUserDuration(int roomId) {
        return repository.getMaxUserDuration( roomId);
    }

    public List<Amenity> getAmenityCount(int roomId, int k) {
        return repository.getAmenityCount( roomId,  k);
    }

    public int getCleanedCount() {
        return repository.getCleanedCount();
    }

    public int getMostCleaningHouseKeeper() {
        return repository.getMostCleaningHouseKeeper();
    }

    public int getMostPendingHouseKeeper() {
        return repository.getMostPendingHouseKeeper();
    }

    public int[] getRoomWithMostHouseKeepers() {
        return repository.getRoomWithMostHouseKeepers();
    }

    public double getAvePriceOfRoomsWithAtLeastKAmenities(int k) {
        return repository.getAvePriceOfRoomsWithAtLeastKAmenities( k);
    }

    public double getAvePriceOfRoomsWithHighestBookingWithAtLeastTDays(int t) {
        return repository.getAvePriceOfRoomsWithHighestBookingWithAtLeastTDays( t);
    }

    public int[] getIdOfMostComAmenities() {
        return repository.getIdOfMostComAmenities();
    }

    public double getAmenitiyDifference() {
        return repository.getAmenitiyDifference();
    }
}
