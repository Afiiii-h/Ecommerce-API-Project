package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.DTO.AddUserResponse;
import com.ecommerce.afifa.DTO.AddUserRequest;
import com.ecommerce.afifa.services.AddUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class AddUserController {

    public final AddUserService addUserService;

    public AddUserController(AddUserService addUserService) {
        this.addUserService = addUserService;
    }

    @PostMapping(path="/api/user/AddUser")
    public AddUserResponse addUser(@RequestBody AddUserRequest addUserBody) throws SQLException {

        return addUserService.addUser(addUserBody);
    }

}
