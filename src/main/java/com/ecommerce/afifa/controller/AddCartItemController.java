package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.DTO.CartItemAddRequestDTO;
import com.ecommerce.afifa.DTO.CartItemResponseDTO;
import com.ecommerce.afifa.services.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart/items")
public class AddCartItemController {

    private final CartItemService service;

    public AddCartItemController(CartItemService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<CartItemResponseDTO> addCartItem(@RequestBody CartItemAddRequestDTO cartItemDTO) {
        return ResponseEntity.ok(service.addItem(cartItemDTO));
    }
}
