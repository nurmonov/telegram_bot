package com.uz.telegrambot.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.uz.telegrambot.entity.Category}
 */
@Value
public class CategoryDTO implements Serializable {
    Integer id;
    String name;
}