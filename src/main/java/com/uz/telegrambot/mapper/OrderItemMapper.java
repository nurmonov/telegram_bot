package com.uz.telegrambot.mapper;

import com.uz.telegrambot.dto.OrderItemDTO;
import com.uz.telegrambot.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemMapper {

    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderItemDTO toOrderItemDTO(OrderItem orderItem);
    OrderItem toOrderItem(OrderItem orderItem);
}
