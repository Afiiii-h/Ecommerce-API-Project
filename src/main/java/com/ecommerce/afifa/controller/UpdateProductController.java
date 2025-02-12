package com.ecommerce.afifa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.ecommerce.afifa.services.UpdateProductService;
import com.ecommerce.afifa.DTO.UpdateProductResponse;
import com.ecommerce.afifa.DTO.UpdateProductRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateProductController {

    @Autowired
    private UpdateProductService updateProductService;

    @PutMapping(path = "/api/product/UpdateProduct")
    public UpdateProductResponse updateProduct(@RequestBody UpdateProductRequest updateProductBody) {
        return updateProductService.updateProduct(updateProductBody);
    }
}
