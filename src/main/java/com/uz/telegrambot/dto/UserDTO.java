package com.uz.telegrambot.dto;

import com.uz.telegrambot.entity.User;
import lombok.Value;

import java.io.Serializable;
import java.util.List;


@Value
public class UserDTO implements Serializable {
    Integer id;
    String firstName;
    String lastName;
    String phone;
    String password;
    List<RolesDTO> roles;
}