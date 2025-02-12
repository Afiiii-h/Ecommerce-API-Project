package com.ecommerce.afifa.services;

import java.sql.SQLException;
import com.ecommerce.afifa.DAO.UsersDao;
import com.ecommerce.afifa.DTO.AddUserRequest;
import com.ecommerce.afifa.DTO.AddUserResponse;
import com.ecommerce.afifa.model.Users;
import org.springframework.stereotype.Component;

@Component
public class AddUserService {

    public final UsersDao usersDao;

    public AddUserService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public AddUserResponse addUser(AddUserRequest request) throws SQLException {

        Users usersTable = new Users();

        usersTable.setFirstName(request.getFirstName());
        usersTable.setLastName(request.getLastName());
        usersTable.setAddress(request.getAddress());
        usersTable.setEmail(request.getEmail());
        usersTable.setLoginName(request.getLoginName());
        usersTable.setPassword(request.getPassword());

        Users dataInsertedByDao=usersDao.save(usersTable); //Insert & Update

        AddUserResponse response=new AddUserResponse();


        response.setErrorCode("0000");
        response.setMessage("User Added Successfully!!");
        response.setRequest(request);

        response.setUser_id(dataInsertedByDao.getUser_id());

        return response;
    }

}
