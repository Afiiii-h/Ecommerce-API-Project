package com.ecommerce.afifa.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductResponse {
    private String errorCode;
    private String message;
    private Integer productId;
    private String productName;

}

