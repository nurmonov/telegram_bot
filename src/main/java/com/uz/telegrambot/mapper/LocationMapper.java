package com.uz.telegrambot.mapper;

import com.uz.telegrambot.dto.LocationDTO;
import com.uz.telegrambot.entity.Location;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    Location toLocation(LocationDTO locationDto);
    LocationDTO toLocationDTO(Location location);
}
