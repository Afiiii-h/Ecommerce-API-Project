package com.ecommerce.afifa.services;

import com.ecommerce.afifa.DAO.OrderDAO;
import com.ecommerce.afifa.DAO.ProductDAO;
import com.ecommerce.afifa.DTO.PlaceOrderResponseDTO;
import com.ecommerce.afifa.DTO.OrderItemResponseDTO;
import com.ecommerce.afifa.model.CartItem;
import com.ecommerce.afifa.model.Orders;
import com.ecommerce.afifa.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private CartItemService cartService;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private ProductDAO productDAO;

    public PlaceOrderResponseDTO placeOrder(Integer userId) {
        List<CartItem> cartItems = cartService.getCartItemsByUserId(userId);

        BigDecimal totalAmount = cartItems.stream()
                .map(item -> BigDecimal.valueOf(item.getProduct().getPrice()).multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Orders order = new Orders();
        order.setUserId(userId);
        order.setTotalAmount(totalAmount);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("COMPLETED");

        List<OrderItem> orderItems = cartItems.stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProductId(item.getProduct().getProduct_id());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(Double.valueOf(item.getProduct().getPrice()));
            return orderItem;
        }).collect(Collectors.toList());

        order.setOrderItems(orderItems);

        orderDAO.save(order);
        cartService.clearCart(userId);

        return convertToPlaceOrderResponseDTO(order);
    }

    private PlaceOrderResponseDTO convertToPlaceOrderResponseDTO(Orders order) {
        PlaceOrderResponseDTO responseDTO = new PlaceOrderResponseDTO();
        responseDTO.setOrderId(order.getId());
        responseDTO.setUserId(order.getUserId());
        responseDTO.setTotalAmount(order.getTotalAmount());
        responseDTO.setStatus(order.getStatus());
        responseDTO.setOrderDate(order.getOrderDate());
        return responseDTO;
    }

    public List<PlaceOrderResponseDTO> getOrderHistory(Integer userId) {
        List<Orders> orders = orderDAO.findByUserId(userId);
        return orders.stream()
                .map(this::convertToOrderResponseDTO)
                .collect(Collectors.toList());
    }

    // Convert Orders to OrderResponseDTO
    private PlaceOrderResponseDTO convertToOrderResponseDTO(Orders order) {
        PlaceOrderResponseDTO orderResponseDTO = new PlaceOrderResponseDTO();
        orderResponseDTO.setOrderId(order.getId());
        orderResponseDTO.setUserId(order.getUserId());
        orderResponseDTO.setTotalAmount(order.getTotalAmount());
        orderResponseDTO.setOrderDate(order.getOrderDate());
        orderResponseDTO.setStatus(order.getStatus());

        List<OrderItemResponseDTO> orderItemResponseDTOs = order.getOrderItems().stream().map(orderItem -> {
            OrderItemResponseDTO orderItemResponseDTO = new OrderItemResponseDTO();
            orderItemResponseDTO.setProductId(orderItem.getId());
            orderItemResponseDTO.setProductName(orderItem.getProduct().getProductName());
            orderItemResponseDTO.setQuantity(orderItem.getQuantity());
            orderItemResponseDTO.setPrice(orderItem.getPrice());
            return orderItemResponseDTO;
        }).collect(Collectors.toList());

        orderResponseDTO.setOrderItems(orderItemResponseDTOs);
        return orderResponseDTO;
    }
}
