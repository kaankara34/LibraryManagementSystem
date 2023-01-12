package edu.ozyegin.cs.repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import edu.ozyegin.cs.entity.Users;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsersRepository {
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
    public boolean createUser(String userName, int UserTypeId) {
        entityManager.createNativeQuery("INSERT INTO users (user_name, userTypeID) VALUES ("+userName+","+ UserTypeId+");").executeUpdate();
        return true;
    }
    @Transactional
    @Modifying
    public boolean renameUser(int userId, String newName) {
        entityManager.createNativeQuery("UPDATE users SET user_name ="+newName+"WHERE userID ="+userId+";").executeUpdate();
        return true;
    }
}
