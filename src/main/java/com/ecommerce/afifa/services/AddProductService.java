package com.ecommerce.afifa.services;

import com.ecommerce.afifa.DAO.ProductDAO;
import com.ecommerce.afifa.DTO.AddProductRequest;
import com.ecommerce.afifa.DTO.AddProductResponse;
import com.ecommerce.afifa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddProductService {

    @Autowired
    ProductDAO productDAO;

    public AddProductResponse addProduct(AddProductRequest request) {

        Product productTable=new Product();

        productTable.setProductName(request.getName());
        productTable.setPrice(request.getPrice());
        productTable.setQuantity(request.getPrice());

        productDAO.save(productTable);

        AddProductResponse response=new AddProductResponse();


        response.setErrorCode("0000");
        response.setMessage("Product added Successfully!!");
        response.setAddProductRequest(request);
        return response;


    }
}
