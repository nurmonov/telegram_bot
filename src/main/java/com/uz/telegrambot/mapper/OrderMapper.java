package com.uz.telegrambot.mapper;

import com.uz.telegrambot.dto.OrderDTO;
import com.uz.telegrambot.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO orderDto);

}
