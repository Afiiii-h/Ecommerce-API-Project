package com.ecommerce.afifa.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProductRequest {

    private int product_id;
    private String name;
    private int quantity;
    private int price;


}
