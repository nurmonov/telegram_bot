package com.uz.telegrambot.controller;

import com.uz.telegrambot.service.TelegramUserService;
import com.uz.telegrambot.dto.TelegramUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telegram-users")
public class TelegramUserController {

    private final TelegramUserService telegramUserService;

    public TelegramUserController(TelegramUserService telegramUserService) {
        this.telegramUserService = telegramUserService;
    }

    @GetMapping
    public ResponseEntity<List<TelegramUserDTO>> getAllTelegramUsers() {
        return ResponseEntity.ok(telegramUserService.getAllTelegramUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelegramUserDTO> getTelegramUserById(@PathVariable Integer id) {
        TelegramUserDTO userDTO = telegramUserService.getTelegramUserById(id);
        return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TelegramUserDTO> createTelegramUser(@RequestBody TelegramUserDTO telegramUserDTO) {
        return ResponseEntity.ok(telegramUserService.createTelegramUser(telegramUserDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelegramUserDTO> updateTelegramUser(@PathVariable Integer id, @RequestBody TelegramUserDTO telegramUserDTO) {
        TelegramUserDTO updatedUser = telegramUserService.updateTelegramUser(id, telegramUserDTO);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelegramUser(@PathVariable Integer id) {
        telegramUserService.deleteTelegramUser(id);
        return ResponseEntity.noContent().build();
    }
}


