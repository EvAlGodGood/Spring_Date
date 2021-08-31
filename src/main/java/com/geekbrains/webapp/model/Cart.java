package com.geekbrains.webapp.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class Cart {

    public List<Order> productCart;

    @PostConstruct
    public void init() {

        productCart = new ArrayList<>(Arrays.asList(
                new Order(1L,1L, "Bread", "OLD",28,"Food"),
                new Order(2L,2L, "Coffee","OLD" ,125,"Food"),
                new Order(3L,3L, "Salt","OLD" ,22,"Food")
        ));
        //для теста
        addToCart(new Order(4L,4L, "Salt_","OLD" ,222,"Food"));
        //для теста
        for (Order order:productCart) {//для теста
            System.out.println(order.toString());
        }
    }

    public Optional<Order> addToCart(Order order) {
        return productCart.add(order);
    }

//    public List<Order> findAll() {
//        return productCart;
//    }

//    public void removeById(Long id_order) {
//        productCart.remove(productCart.stream().filter(i -> i.getId().equals(id_order)).findFirst().get());
//    }

}
