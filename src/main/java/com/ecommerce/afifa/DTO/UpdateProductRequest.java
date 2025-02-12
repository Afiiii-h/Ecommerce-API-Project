package com.ecommerce.afifa.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {
    private Integer productId;
    private String productName;
    private Double price;
    private String description; // Add more fields as necessary

}
