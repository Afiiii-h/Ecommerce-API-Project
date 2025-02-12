package com.ecommerce.afifa.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemResponseDTO {
    private Integer productId;
    private String productName;
    private int quantity;
    private double price;

}

