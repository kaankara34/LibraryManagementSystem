package edu.ozyegin.cs.repository;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import edu.ozyegin.cs.entity.*;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HouseKeepingRepository {
    @PersistenceContext

    private EntityManager entityManager;

    @Transactional
    @Modifying
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
    public boolean scheduleRoom(int roomId, int userId) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        entityManager.createNativeQuery("INSERT INTO cleaning (userID, roomID,cleaned,cleaning_date) VALUES ("+userId+","+roomId+",false,"+dtf.format(now)+");\n").executeUpdate();
        return true;
    }
    @Transactional
    @Modifying
    public boolean cleanRoom(int roomId) {
        entityManager.createNativeQuery("UPDATE cleaning SET cleaned = true WHERE roomID ="+roomId+";").executeUpdate();
        return true;
    }
    @Transactional
    @Modifying
    public int[] getRoomsRequiredToClean() {
        Query query = entityManager.createNativeQuery("SELECT room.roomID, cleaning.cleaning_date\n" +
                "FROM cleaning JOIN room\n" +
                "ON cleaning.roomID = room.roomID\n" +
                "WHERE cleaning.cleaned = false;");
        int[] result = new int[query.executeUpdate()];
        return result;
    }
}
