package com.uz.telegrambot.repo;

import com.uz.telegrambot.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUserRepository extends JpaRepository<TelegramUser, Integer> {
}