package com.uz.telegrambot.dto;

import com.uz.telegrambot.entity.TelegramUser;
import lombok.Value;

import java.io.Serializable;


@Value
public class TelegramUserDTO implements Serializable {
    Integer id;
    Integer telegramId;
    String username;
    String firstName;
    String lastName;
    String phoneNumber;
}