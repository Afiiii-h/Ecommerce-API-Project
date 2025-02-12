package com.ecommerce.afifa.controller;

import com.ecommerce.afifa.DTO.PlaceOrderRequestDTO;
import com.ecommerce.afifa.DTO.PlaceOrderResponseDTO;
import com.ecommerce.afifa.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Place order API
    @PostMapping("/place")
    public ResponseEntity<PlaceOrderResponseDTO> placeOrder(@RequestBody PlaceOrderRequestDTO placeOrderRequestDTO) {
        Integer userId = placeOrderRequestDTO.getUserId();

        PlaceOrderResponseDTO orderResponseDTO = orderService.placeOrder(userId);

        return new ResponseEntity<>(orderResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<PlaceOrderResponseDTO>> getOrderHistory(@PathVariable Integer userId) {
        List<PlaceOrderResponseDTO> orderHistory = orderService.getOrderHistory(userId);
        return new ResponseEntity<>(orderHistory, HttpStatus.OK);
    }
}
