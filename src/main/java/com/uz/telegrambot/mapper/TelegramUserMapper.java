package com.uz.telegrambot.mapper;

import com.uz.telegrambot.dto.TelegramUserDTO;
import com.uz.telegrambot.entity.TelegramUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TelegramUserMapper {

    TelegramUserMapper INSTANCE = Mappers.getMapper(TelegramUserMapper.class);

    TelegramUserDTO toTelegramUserDTO(TelegramUser telegramUser);
    TelegramUser toTelegramUser(TelegramUserDTO telegramUserDto);
}
