package com.ecommerce.afifa.services;

import com.ecommerce.afifa.DAO.ProductDAO;
import com.ecommerce.afifa.DTO.UpdateProductRequest;
import com.ecommerce.afifa.DTO.UpdateProductResponse;
import com.ecommerce.afifa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService {

    @Autowired
    private ProductDAO productDao;

    public UpdateProductResponse updateProduct(UpdateProductRequest request) {
        UpdateProductResponse response = new UpdateProductResponse();

        // Validate product ID
        if (request.getProductId() == null) {
            response.setErrorCode("911");
            response.setMessage("Product ID not found");
            return response;
        }

        // Find the product by ID
        Optional<Product> productOptional = productDao.findById(request.getProductId());
        if (!productOptional.isPresent()) {
            response.setErrorCode("912");
            response.setMessage("Product not found in the database");
            return response;
        }

        // Get the product and update fields
        Product product = productOptional.get();
        product.setProductName(request.getProductName());
        product.setPrice(request.getPrice());

        // Save the updated product
        productDao.save(product);

        // Set success response
        response.setErrorCode("0000");
        response.setMessage("Product updated successfully");
        response.setProductId(product.getProduct_id());
        response.setProductName(product.getProductName());

        return response;
    }
}

