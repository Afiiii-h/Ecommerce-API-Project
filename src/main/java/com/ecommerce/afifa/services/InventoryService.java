package com.ecommerce.afifa.services;

import com.ecommerce.afifa.DAO.InventoryDAO;
import com.ecommerce.afifa.DTO.InventoryItemRequest;
import com.ecommerce.afifa.DTO.InventoryItemResponse;
import com.ecommerce.afifa.model.InventoryItem;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    private final InventoryDAO inventoryDAO;
    private Long id;

    @Autowired
    public InventoryService(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    public boolean deleteInventory(Long id) {
        if (inventoryDAO.existsById(id)) {
            inventoryDAO.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public InventoryItemResponse addInventoryItem(InventoryItemRequest itemDTO) {
        InventoryItem item = new InventoryItem(itemDTO.getProductName(), itemDTO.getQuantity(), itemDTO.getPrice());
        InventoryItem savedItem = inventoryDAO.save(item);
        return new InventoryItemResponse(savedItem.getId(), savedItem.getProductName(), savedItem.getQuantity(), savedItem.getPrice());
    }

    public InventoryItemResponse updateInventoryItem(Long id, InventoryItemRequest updatedItemDTO) {
        InventoryItem updatedItem = inventoryDAO.findById(id).map(item -> {
            item.setProductName(updatedItemDTO.getProductName());
            item.setQuantity(updatedItemDTO.getQuantity());
            item.setPrice(updatedItemDTO.getPrice());
            return inventoryDAO.save(item);
        }).orElseThrow(() -> new EntityNotFoundException("Item not found"));
        return new InventoryItemResponse(updatedItem.getId(), updatedItem.getProductName(), updatedItem.getQuantity(), updatedItem.getPrice());
    }

    public List<InventoryItemResponse> getAllItems() {
        return inventoryDAO.findAll().stream()
                .map(item -> new InventoryItemResponse(item.getId(), item.getProductName(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());
    }

    public InventoryItemResponse getInventoryItemById(Long id) {
        InventoryItem item = inventoryDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Item not found"));
        return new InventoryItemResponse(item.getId(), item.getProductName(), item.getQuantity(), item.getPrice());
    }

    public void deleteInventoryItem(Long id) {
        inventoryDAO.deleteById(id);
    }
}
