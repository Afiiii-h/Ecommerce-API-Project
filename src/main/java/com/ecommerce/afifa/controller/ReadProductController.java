package com.ecommerce.afifa.controller;

import java.util.List;

import com.ecommerce.afifa.model.Product;
import com.ecommerce.afifa.services.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadProductController {

    @Autowired
    ProductManagementService productManagementService;

    // Get all products
    @GetMapping(path = "/api/product/getAllProducts")
    public List<Product> getAllProducts() {
        return productManagementService.getAllProducts();
    }

}
