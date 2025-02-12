package com.ecommerce.afifa.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CartItemResponseDTO {
    private Integer id;
    private String productName;
    private int quantity;
    private Integer userId;
}
