package com.uz.telegrambot.dto;

import lombok.Value;

import java.io.Serializable;


@Value
public class LocationDTO implements Serializable {
    Integer id;
    Double latitude;
    Double longitude;
    String address;
}