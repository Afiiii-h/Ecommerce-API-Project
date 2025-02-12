package com.ecommerce.afifa.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProductResponse {

    private String errorCode;
    private String message;
    private Integer product_id;
    private AddProductRequest addProductRequest;


}
