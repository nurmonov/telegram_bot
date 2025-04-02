package com.uz.telegrambot.mapper;

import com.uz.telegrambot.dto.AttachmentContentDTO;
import com.uz.telegrambot.entity.AttachmentContent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttachmentContentMapper {

    AttachmentContentMapper INSTANCE = Mappers.getMapper(AttachmentContentMapper.class);

    AttachmentContentDTO toAttachmentContentDTO(AttachmentContent attachment);
    AttachmentContent toAttachmentContent(AttachmentContentDTO attachmentDTO);
}
