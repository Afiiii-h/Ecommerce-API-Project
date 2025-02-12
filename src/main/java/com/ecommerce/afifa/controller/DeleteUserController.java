package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.DTO.DeleteUserResponse;
import com.ecommerce.afifa.services.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteUserController {

    @Autowired
    DeleteUserService deleteUserService;

    @DeleteMapping(path="/api/user/deleteUserById/{userId}")
    public ResponseEntity<DeleteUserResponse> deleteByUserId(@PathVariable Integer userId) {
        DeleteUserResponse response = deleteUserService.deleteUserById(userId);
        return ResponseEntity.ok(response);
    }


}
