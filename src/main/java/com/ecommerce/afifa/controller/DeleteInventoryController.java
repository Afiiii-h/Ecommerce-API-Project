package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class DeleteInventoryController {

    @Autowired
    private InventoryService inventoryService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable("id") Long id) {
        boolean isDeleted = inventoryService.deleteInventory(id);

        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Inventory item deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inventory item not found.");
        }
    }
}

