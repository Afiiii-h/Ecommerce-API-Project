package com.ecommerce.afifa.DAO;

import com.ecommerce.afifa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer>{


}
