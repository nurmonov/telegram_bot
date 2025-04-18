package com.uz.telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MyTelegramBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@G47_nurmonov_bot";
    }

    @Override
    public String getBotToken() {
        return "8185776481:AAGeLj3gsaLFLY94BC8ZYaZFwfbyrKwz_44";
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Xabarlarni qayta ishlash lozim
        if(update.hasMessage() && update.getMessage().hasText()){
            String receivedMessage = update.getMessage().getText();
            // Misol: oddiy javob qaytarish
            sendMessage(update.getMessage().getChatId(), "Siz: " + receivedMessage);
        }
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Test xabari: Salom, Telegram bot!");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

