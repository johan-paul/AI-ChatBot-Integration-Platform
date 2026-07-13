package com.johan.chatBotIntegration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johan.chatBotIntegration.model.ChatBot;


@Repository
public interface ChatBotRepository extends JpaRepository<ChatBot,Long>{
    List<ChatBot> findByPlatform(String platform);
} 