package com.ecommerce.afifa.DAO;

import com.ecommerce.afifa.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemDAO extends JpaRepository<OrderItem, Long> {
}