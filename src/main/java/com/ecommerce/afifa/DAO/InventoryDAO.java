package com.ecommerce.afifa.DAO;

import com.ecommerce.afifa.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InventoryDAO extends JpaRepository<InventoryItem, Long> {

    Optional<InventoryItem> findByProductName(String productName);
}

