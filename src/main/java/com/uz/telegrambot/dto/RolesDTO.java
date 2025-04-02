package com.uz.telegrambot.dto;

import com.uz.telegrambot.entity.Roles;
import com.uz.telegrambot.enums.UserRole;
import lombok.Value;

import java.io.Serializable;


@Value
public class RolesDTO implements Serializable {
    Integer id;
    UserRole role;
}