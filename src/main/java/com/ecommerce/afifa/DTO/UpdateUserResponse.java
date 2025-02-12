package com.ecommerce.afifa.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserResponse {
    private String errorCode;
    private String message;

    // Updated user data
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String loginName;
}
