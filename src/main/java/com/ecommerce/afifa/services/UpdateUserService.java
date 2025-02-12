package com.ecommerce.afifa.services;

import java.util.Optional;

import com.ecommerce.afifa.DAO.UsersDao;
import com.ecommerce.afifa.DTO.UpdateUserRequest;
import com.ecommerce.afifa.DTO.UpdateUserResponse;
import com.ecommerce.afifa.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserService {

    @Autowired
    private UsersDao usersDao;

    public UpdateUserResponse updateUser(Integer userId, UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();

        // If user_id not sent in request
        if (userId == null) {
            response.setErrorCode("911");
            response.setMessage("User_id Not Found");
            return response;
        }

        // If user_id not present in DB
        Optional<Users> userOptional = usersDao.findById(userId);

        if (!userOptional.isPresent()) {
            response.setErrorCode("912");
            response.setMessage("User_id Not Present in DB");
            return response;
        }

        // Get the existing user from the database
        Users user = userOptional.get();

        // Update user fields
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        user.setLoginName(request.getLoginName());
        user.setPassword(request.getPassword());

        // Save updated user to the database
        usersDao.save(user);

        // Set success response with updated data
        response.setErrorCode("0000");
        response.setMessage("User updated successfully!");
        response.setUserId(user.getUser_id());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setAddress(user.getAddress());
        response.setLoginName(user.getLoginName());

        return response;
    }
}
