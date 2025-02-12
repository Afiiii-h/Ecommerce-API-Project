package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.services.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart/items")
public class DeleteCartItemController {

    private final CartItemService service;

    public DeleteCartItemController(CartItemService service) {
        this.service = service;
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long id) {
        service.removeItem(id);
        return ResponseEntity.noContent().build();
    }
}
