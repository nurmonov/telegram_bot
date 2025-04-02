package com.uz.telegrambot.dto;

import com.uz.telegrambot.entity.OrderItem;
import com.uz.telegrambot.entity.User;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Value
public class OrderDTO implements Serializable {
    Integer id;
    User user;
    List<OrderItem> orderItems;
    BigDecimal totalPrice;
}