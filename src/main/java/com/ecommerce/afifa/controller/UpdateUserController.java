package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.DTO.UpdateUserRequest;
import com.ecommerce.afifa.DTO.UpdateUserResponse;
import com.ecommerce.afifa.services.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateUserController {

    @Autowired
    private UpdateUserService updateUserService;

    @PutMapping("/api/Updateuser/{userId}")
    public ResponseEntity<UpdateUserResponse> updateUser(
            @PathVariable Integer userId,
            @RequestBody UpdateUserRequest userRequest) {

        UpdateUserResponse response = updateUserService.updateUser(userId, userRequest);
        return ResponseEntity.ok(response);  // Returning the updated response
    }
}
