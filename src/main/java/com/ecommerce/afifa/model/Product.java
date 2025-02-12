package com.ecommerce.afifa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product {

    @GeneratedValue
    @Id
    @Column
    private Integer product_id;

    @Column
    @Getter
    @Setter
    private String productName;

    @Column
    private int quantity;

    @Column
    private double price;



}
