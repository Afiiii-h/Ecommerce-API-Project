package com.ecommerce.afifa.DTO;

import lombok.Data;

@Data
public class CartItemUpdateRequestDTO {
    private Integer productId;
    private int quantity;
}
