package com.uz.telegrambot.dto;


import lombok.Value;

@Value
public class AttachmentDTO {
    Integer id;
    String fileName;
    String contentType;
    long size;
}
