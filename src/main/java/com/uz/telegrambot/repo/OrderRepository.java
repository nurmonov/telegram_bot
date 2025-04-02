package com.uz.telegrambot.repo;

import com.uz.telegrambot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}