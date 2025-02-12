package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.DTO.InventoryItemRequest;
import com.ecommerce.afifa.DTO.InventoryItemResponse;
import com.ecommerce.afifa.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory/update")
public class UpdateInventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public UpdateInventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryItemResponse> updateItem(@PathVariable Long id, @RequestBody InventoryItemRequest itemDTO) {
        InventoryItemResponse updatedItem = inventoryService.updateInventoryItem(id, itemDTO);
        return ResponseEntity.ok(updatedItem);
    }
}

