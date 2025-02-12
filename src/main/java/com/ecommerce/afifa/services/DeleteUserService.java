package com.ecommerce.afifa.services;

import com.ecommerce.afifa.DAO.UsersDao;
import com.ecommerce.afifa.DTO.DeleteUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserService {

    @Autowired
    UsersDao user;

    public DeleteUserResponse deleteUserById(Integer userid) {
        DeleteUserResponse response = new DeleteUserResponse();  // Create a new instance
        if (user.existsById(userid)) {
            user.deleteById(userid);
            response.setErrorCode("0000");
            response.setMessage("User Deleted Successfully!!");
        } else {
            response.setErrorCode("404");
            response.setMessage("User not found with ID: " + userid);
        }
        return response;
    }


}
