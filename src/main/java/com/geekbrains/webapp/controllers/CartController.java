package com.geekbrains.webapp.controllers;

import com.geekbrains.webapp.dtos.CategoryDto;
import com.geekbrains.webapp.dtos.ProductDto;
import com.geekbrains.webapp.exceptions.ResourceNotFoundException;
import com.geekbrains.webapp.model.Cart;
import com.geekbrains.webapp.model.Order;
import com.geekbrains.webapp.services.CartService;
import com.geekbrains.webapp.services.CategoryService;
import com.sun.xml.bind.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Calendar;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    Calendar calendar;
    DateFormat dateFormat;
//    @GetMapping("/{id}")
//    public Cart findById(@PathVariable Long id) {
//        return new Cart(cartService.findByIdWithCart(id).orElseThrow(
//                    () -> new ResourceNotFoundException("Cart id = " + id + " not found")));
//
//    }

    @GetMapping("/addToCart")
    public void addToCart (ProductDto productDto) {
        Order order = new Order();
        order.setId(productDto.getId());
        order.setPrice(productDto.getPrice());
        order.setDate(dateFormat.format(calendar.getTime()));
        order.setTitle(productDto.getTitle());
        order.setCategory(productDto.getCategoryTitle());
        System.out.println(order.toString());
        cartService.addToCart(order);
    }

}
