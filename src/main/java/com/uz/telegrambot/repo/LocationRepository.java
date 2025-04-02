package com.uz.telegrambot.repo;

import com.uz.telegrambot.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}