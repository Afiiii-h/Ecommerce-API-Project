package com.ecommerce.afifa.DAO;

import com.ecommerce.afifa.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Orders, Integer> {
    List<Orders> findByUserId(Integer userId);
}

