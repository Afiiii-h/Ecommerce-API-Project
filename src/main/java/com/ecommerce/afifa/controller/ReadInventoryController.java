package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.DTO.InventoryItemResponse;
import com.ecommerce.afifa.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory/read")
public class ReadInventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public ReadInventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<InventoryItemResponse>> getAllItems() {
        return ResponseEntity.ok(inventoryService.getAllItems());
    }

}