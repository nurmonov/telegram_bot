package com.uz.telegrambot.mapper;

import com.uz.telegrambot.dto.CategoryDTO;
import com.uz.telegrambot.dto.CategoryDTO;
import com.uz.telegrambot.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO toCategoryDTO(Category category);
    Category toCategory(CategoryDTO categoryDto);
}
