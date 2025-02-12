package com.ecommerce.afifa.services;

import com.ecommerce.afifa.model.Product;
import com.ecommerce.afifa.DAO.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagementService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }
}
