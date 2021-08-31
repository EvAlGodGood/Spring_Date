package com.geekbrains.webapp.repositories;

import com.geekbrains.webapp.model.Cart;
import com.geekbrains.webapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {


}
