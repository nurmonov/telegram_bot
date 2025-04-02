package com.uz.telegrambot.mapper;


import com.uz.telegrambot.dto.RolesDTO;
import com.uz.telegrambot.entity.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolesMapper {

    RolesMapper INSTANCE = Mappers.getMapper(RolesMapper.class);

    RolesDTO toRolesDTO(Roles roles);
    Roles toRoles(RolesDTO rolesDto);
}
