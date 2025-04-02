package com.uz.telegrambot.entity;


import com.uz.telegrambot.base.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TelegramUser extends BaseEntity {
    private Integer telegramId;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
