package com.uz.telegrambot.dto;

import com.uz.telegrambot.entity.Attachment;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;


@Value
public class ProductDTO implements Serializable {
    Integer id;
    String name;
    BigDecimal price;
    CategoryDTO category;
    Attachment attachment;
}