package com.uz.telegrambot.dto;



import lombok.Value;

@Value
public class AttachmentContentDTO {
    Integer attachmentId;
    byte[] data;
}
