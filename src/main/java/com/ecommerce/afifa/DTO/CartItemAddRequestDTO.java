package com.ecommerce.afifa.DTO;

import lombok.Data;

@Data
public class CartItemAddRequestDTO {
    private Integer productId;
    private int quantity;
    private Integer userId;
}
