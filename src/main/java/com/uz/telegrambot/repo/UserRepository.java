package com.uz.telegrambot.repo;

import com.uz.telegrambot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByPhone(String phone);
}