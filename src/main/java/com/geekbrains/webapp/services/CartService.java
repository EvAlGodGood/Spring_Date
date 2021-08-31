package com.geekbrains.webapp.services;

import com.geekbrains.webapp.model.Cart;
import com.geekbrains.webapp.model.Category;
import com.geekbrains.webapp.model.Order;
import com.geekbrains.webapp.repositories.CartRepository;
import com.geekbrains.webapp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    public Optional<Order> addToCart(Order order){
        return Cart.addToCart(order);
    }

//    public Optional<Cart> findByIdWithCart(Long id) {
//        return cartRepository.findByIdWithCarts(id);
//    }
}
