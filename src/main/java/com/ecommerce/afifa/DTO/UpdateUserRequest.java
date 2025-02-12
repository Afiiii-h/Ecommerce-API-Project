package com.ecommerce.afifa.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserRequest {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String loginName;
    private String password;
}
