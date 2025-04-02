package com.uz.telegrambot.repo;

import com.uz.telegrambot.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}