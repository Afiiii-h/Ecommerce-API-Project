package com.ecommerce.afifa.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemRequestDTO {

    private Long productId;
    private int quantity;

}
