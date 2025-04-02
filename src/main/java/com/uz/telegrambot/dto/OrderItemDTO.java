package com.uz.telegrambot.dto;

import com.uz.telegrambot.entity.OrderItem;
import com.uz.telegrambot.entity.Product;
import lombok.Value;

import java.io.Serializable;

@Value
public class OrderItemDTO implements Serializable {
    Integer id;
    OrderDTO order;
    Product product;
    int quantity;
}