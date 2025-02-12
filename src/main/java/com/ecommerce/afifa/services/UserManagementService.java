package com.ecommerce.afifa.services;

import java.sql.SQLException;
import java.util.List;
import com.ecommerce.afifa.model.Users;
import com.ecommerce.afifa.DAO.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManagementService {

    @Autowired
    UsersDao user;

    public List<Users> getAllUser() throws SQLException{

        return user.findAll();
    }

    public Users getUserById(Integer userId){
        return user.findById(userId).get();
    }
}
