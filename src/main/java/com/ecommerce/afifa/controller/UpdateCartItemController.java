package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.DTO.CartItemUpdateRequestDTO;
import com.ecommerce.afifa.DTO.CartItemResponseDTO;
import com.ecommerce.afifa.services.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart/items")
public class UpdateCartItemController {

    private final CartItemService service;

    public UpdateCartItemController(CartItemService service) {
        this.service = service;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CartItemResponseDTO> updateCartItem(@PathVariable Long id, @RequestBody CartItemUpdateRequestDTO cartItemDTO) {
        return ResponseEntity.ok(service.updateItem(id, cartItemDTO));
    }
}
