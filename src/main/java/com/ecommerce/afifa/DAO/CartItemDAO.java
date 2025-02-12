package com.ecommerce.afifa.DAO;

import com.ecommerce.afifa.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemDAO extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Integer userId);
}
