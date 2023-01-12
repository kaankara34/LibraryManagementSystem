package edu.ozyegin.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ozyegin.cs.entity.Users;
import edu.ozyegin.cs.repository.UserTypeRepository;
import edu.ozyegin.cs.repository.UsersRepository;

@Service
public class UsersService {

    @Autowired
    UsersRepository repository;

    public  String check_role(int callerId){
        return repository.check_role(callerId);
    }
    public boolean createUser(String UserName, int UserTypeId) {
        return repository.createUser(UserName,UserTypeId);
    }
    public boolean renameUser( int UserId, String NewName) {
        return repository.renameUser(UserId,NewName);

    }
}
