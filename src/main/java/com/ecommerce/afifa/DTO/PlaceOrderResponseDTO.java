package com.ecommerce.afifa.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class PlaceOrderResponseDTO {

    private Integer orderId;
    private Integer userId;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private String status;
    private List<OrderItemResponseDTO> orderItems;

}

