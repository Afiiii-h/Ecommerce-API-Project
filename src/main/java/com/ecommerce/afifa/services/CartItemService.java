package com.ecommerce.afifa.services;

import com.ecommerce.afifa.DTO.CartItemAddRequestDTO;
import com.ecommerce.afifa.DTO.CartItemResponseDTO;
import com.ecommerce.afifa.DTO.CartItemUpdateRequestDTO;
import com.ecommerce.afifa.model.CartItem;
import com.ecommerce.afifa.model.Product;
import com.ecommerce.afifa.DAO.CartItemDAO;
import com.ecommerce.afifa.DAO.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemService {

    private final CartItemDAO cartItemDAO;
    private final ProductDAO productDAO;

    public CartItemService(CartItemDAO cartItemDAO, ProductDAO productDAO) {
        this.cartItemDAO = cartItemDAO;
        this.productDAO = productDAO;
    }

    public List<CartItem> getCartItemsByUserId(Integer userId) {
        return cartItemDAO.findByUserId(userId);
    }

    public void clearCart(Integer userId) {
        List<CartItem> cartItems = cartItemDAO.findByUserId(userId);
        cartItemDAO.deleteAll(cartItems);
    }

    public List<CartItemResponseDTO> getItemsByUserId(Integer userId) {
        List<CartItem> items = cartItemDAO.findByUserId(userId);
        return items.stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    public CartItemResponseDTO addItem(CartItemAddRequestDTO cartItemAddRequestDTO) {
        Product product = productDAO.findById(cartItemAddRequestDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(cartItemAddRequestDTO.getQuantity());
        cartItem.setUserId(cartItemAddRequestDTO.getUserId());
        cartItem = cartItemDAO.save(cartItem);
        return convertToResponseDTO(cartItem);
    }

    public CartItemResponseDTO updateItem(Long id, CartItemUpdateRequestDTO updatedItemDTO) {
        return cartItemDAO.findById(id).map(item -> {
            Product product = productDAO.findById(updatedItemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            item.setProduct(product);
            item.setQuantity(updatedItemDTO.getQuantity());
            CartItem updatedItem = cartItemDAO.save(item);
            return convertToResponseDTO(updatedItem);
        }).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public void removeItem(Long id) {
        cartItemDAO.deleteById(id);
    }

    private CartItemResponseDTO convertToResponseDTO(CartItem cartItem) {
        CartItemResponseDTO responseDTO = new CartItemResponseDTO();
        responseDTO.setId(cartItem.getId());
        responseDTO.setProductName(cartItem.getProduct().getProductName());
        responseDTO.setQuantity(cartItem.getQuantity());
        responseDTO.setUserId(cartItem.getUserId());
        return responseDTO;
    }
}
