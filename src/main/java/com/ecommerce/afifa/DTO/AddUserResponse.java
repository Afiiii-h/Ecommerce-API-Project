package com.ecommerce.afifa.DTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddUserResponse {

    private String errorCode;
    private String message;
    private Integer user_id;

    private AddUserRequest request;

}
