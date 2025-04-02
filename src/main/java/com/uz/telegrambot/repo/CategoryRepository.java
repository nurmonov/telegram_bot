package com.uz.telegrambot.repo;

import com.uz.telegrambot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}