package com.ecommerce.afifa.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PlaceOrderRequestDTO {
    private Integer userId;
    private List<OrderItemRequestDTO> orderItems;

}

