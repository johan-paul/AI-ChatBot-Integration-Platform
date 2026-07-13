package com.johan.chatBotIntegration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johan.chatBotIntegration.model.ChatBot;
import com.johan.chatBotIntegration.repository.ChatBotRepository;


@Service
public class ChatBotService {
    @Autowired
    private ChatBotRepository chatBotRepository;

    public ChatBot saveChatBot(ChatBot chatBot){
        return chatBotRepository.save(chatBot);
    }

    public List<ChatBot> getAllChatBots(){
        return chatBotRepository.findAll();
    }

    public List<ChatBot> getIntegrationStatus(String platform){
        return chatBotRepository.findByPlatform(platform);
    }

    public void deleteChatBot(Long id){
        chatBotRepository.deleteById(id);
    }
}
