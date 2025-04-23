package com.uz.telegrambot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



public class test {

    private int id;

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

    }
}
