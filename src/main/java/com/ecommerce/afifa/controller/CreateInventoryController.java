package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.DTO.InventoryItemRequest;
import com.ecommerce.afifa.DTO.InventoryItemResponse;
import com.ecommerce.afifa.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory/create")
public class CreateInventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public CreateInventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<InventoryItemResponse> addItem(@RequestBody InventoryItemRequest itemDTO) {
        InventoryItemResponse addedItem = inventoryService.addInventoryItem(itemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedItem);
    }
}
