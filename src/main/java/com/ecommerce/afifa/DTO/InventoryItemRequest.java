package com.ecommerce.afifa.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItemRequest {
    private String productName;
    private int quantity;
    private double price;

}
