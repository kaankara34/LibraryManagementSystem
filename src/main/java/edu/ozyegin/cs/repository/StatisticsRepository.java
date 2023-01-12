package edu.ozyegin.cs.repository;

import java.util.Arrays;
import java.util.List;
import edu.ozyegin.cs.entity.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StatisticsRepository {
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

    public int getNoOfBookings(int roomId) {
        Query query = entityManager.createNativeQuery("SELECT COUNT(p.bookingID) as bookings_count\n" +
                "FROM payments p\n" +
                "JOIN rooms r ON p.bookingID = r.bookingID\n" +
                "WHERE r.roomID ="+roomId+";");
        int resultset = query.getFirstResult();
        return resultset;
    }

    public double getConversionRate(int roomId) {

        return 1.0;
    }

    public float getAveragePrice(int roomId) {
        Query query = entityManager.createNativeQuery("SELECT AVG(p.price) as avg_price\n" +
                "FROM payments p\n" +
                "JOIN rooms r ON p.bookingID = r.bookingID\n" +
                "WHERE r.roomID ="+roomId+";");

        float resultset = query.getFirstResult();
        return resultset;
    }

    public int getMaxUserBookings(int roomId) {
        Query query = entityManager.createNativeQuery("SELECT userID, COUNT(*) as booking_count\n" +
                "FROM booking\n" +
                "WHERE roomID ="+roomId+"\n" +
                "GROUP BY userID\n" +
                "ORDER BY booking_count DESC\n" +
                "LIMIT 1;");
        int result = query.getFirstResult();
        return result;
    }

    public int getMaxUserDuration(int roomId) {
        Query query = entityManager.createNativeQuery("SELECT userID, SUM(TIMESTAMPDIFF(SECOND, check_in, check_out)) AS total_duration \n" +
                "FROM checks\n" +
                "WHERE roomID ="+roomId+"\n" +
                "GROUP BY userID\n" +
                "ORDER BY total_duration DESC\n" +
                "LIMIT 1;");
        int result = query.getFirstResult();
        return result;
    }

    public List<Amenity> getAmenityCount(int roomId, int k) {
        Query query = entityManager.createNativeQuery("SELECT AVG(p.price) as avg_price\n" +
                "FROM payments p\n" +
                "JOIN rooms r ON p.bookingID = r.bookingID\n" +
                "JOIN roomsAmenities ra ON r.roomID = ra.roomID\n" +
                "WHERE ra.roomID ="+roomId+"\n" +
                "GROUP BY ra.roomID\n" +
                "HAVING COUNT(DISTINCT ra.amenityID) >="+k+";");
        List<Amenity> result = query.getResultList();
        return result;
    }

    public int getCleanedCount() {
        Query query = entityManager.createNativeQuery("SELECT COUNT(*) as total_finished_tasks FROM cleaning \n" +
                "WHERE cleaned = TRUE;");
        int result = query.getFirstResult();
        return result;
    }

    public int getMostCleaningHouseKeeper() {
        Query query = entityManager.createNativeQuery("SELECT userID, COUNT(roomID) as cleaned_rooms\n" +
                "FROM cleaning\n" +
                "WHERE cleaned = TRUE\n" +
                "GROUP BY userID\n" +
                "ORDER BY cleaned_rooms DESC\n" +
                "LIMIT 1;");
        int result = query.getFirstResult();
        return result;
    }

    public int getMostPendingHouseKeeper() {
        Query query = entityManager.createNativeQuery("SELECT userID, COUNT(*) as pending_tasks\n" +
                "FROM cleaning\n" +
                "WHERE cleaned = false\n" +
                "GROUP BY userID\n" +
                "ORDER BY pending_tasks DESC\n" +
                "LIMIT 1;");
        int result = query.getFirstResult();
        return result;
    }

    public int[] getRoomWithMostHouseKeepers() {
        Query query = entityManager.createNativeQuery("SELECT roomID, COUNT(DISTINCT userID) as different_housekeepers\n" +
                "FROM cleaning\n" +
                "GROUP BY roomID\n" +
                "ORDER BY different_housekeepers DESC\n" +
                "LIMIT 1;");
        int[] result = new int[]{query.executeUpdate()};
        return result;
    }

    public double getAvePriceOfRoomsWithAtLeastKAmenities(int k) {
        return 1.0;
    }

    public double getAvePriceOfRoomsWithHighestBookingWithAtLeastTDays(int t) {
        return 1.0;
    }

    public int[] getIdOfMostComAmenities() {
        Query query = entityManager.createNativeQuery("SELECT amenityID, COUNT(amenityID) as count\n" +
                "FROM roomsAmenities\n" +
                "GROUP BY amenityID\n" +
                "ORDER BY count DESC\n" +
                "LIMIT 1;");
        int[] result = new int[]{query.executeUpdate()};
        return result;
    }

    public double getAmenitiyDifference() {
        Query query = entityManager.createNativeQuery("WITH most_common_amenity AS (\n" +
                "  SELECT amenityID, COUNT(*) AS count\n" +
                "  FROM roomsAmenities\n" +
                "  GROUP BY amenityID\n" +
                "  ORDER BY count DESC\n" +
                "  LIMIT 1\n" +
                "),\n" +
                "second_common_amenity AS (\n" +
                "  SELECT amenityID, COUNT(*) AS count\n" +
                "  FROM roomsAmenities\n" +
                "  WHERE amenityID != (SELECT amenityID FROM most_common_amenity)\n" +
                "  GROUP BY amenityID\n" +
                "  ORDER BY count DESC\n" +
                "  LIMIT 1\n" +
                ")\n" +
                "SELECT \n" +
                "SUM(CASE\n" +
                "  WHEN ra1.amenityID = (SELECT amenityID FROM most_common_amenity) AND ra2.amenityID != (SELECT amenityID FROM second_common_amenity) THEN r.price\n" +
                "  ELSE 0\n" +
                "END) - SUM(CASE\n" +
                "  WHEN ra1.amenityID != (SELECT amenityID FROM most_common_amenity) AND ra2.amenityID = (SELECT amenityID FROM second_common_amenity) THEN r.price\n" +
                "  ELSE 0\n" +
                "END) as price_difference\n" +
                "FROM rooms r\n" +
                "LEFT JOIN roomsAmenities ra1 ON r.roomID = ra1.roomID\n" +
                "LEFT JOIN roomsAmenities ra2 ON r.roomID = ra2.roomID");
        double result = query.getFirstResult()/1.0;
        return result;
    }
}
