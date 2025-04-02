package com.uz.telegrambot.repo;

import com.uz.telegrambot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}