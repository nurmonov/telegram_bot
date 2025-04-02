package com.uz.telegrambot.mapper;

import com.uz.telegrambot.dto.AttachmentDTO;
import com.uz.telegrambot.entity.Attachment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttachmentMapper {

    AttachmentMapper INSTANCE = Mappers.getMapper(AttachmentMapper.class);

    AttachmentDTO toAttachmentDTO(Attachment attachment) ;
    Attachment toAttachment(AttachmentDTO attachmentDTO);

}
