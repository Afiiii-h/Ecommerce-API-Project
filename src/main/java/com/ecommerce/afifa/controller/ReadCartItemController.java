package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.DTO.CartItemResponseDTO;
import com.ecommerce.afifa.services.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart/items")
public class ReadCartItemController {

    private final CartItemService service;

    public ReadCartItemController(CartItemService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public List<CartItemResponseDTO> getCartItems(@PathVariable Integer userId) {
        return service.getItemsByUserId(userId);
    }

}
