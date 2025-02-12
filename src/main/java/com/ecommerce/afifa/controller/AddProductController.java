package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.DTO.AddProductRequest;
import com.ecommerce.afifa.DTO.AddProductResponse;
import com.ecommerce.afifa.services.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddProductController {

    @Autowired
    private AddProductService addProductService;

    @PostMapping(path="/api/product/add product")
    public AddProductResponse addProduct(@RequestBody AddProductRequest addProductBody) {

        return addProductService.addProduct(addProductBody);
    }
}
