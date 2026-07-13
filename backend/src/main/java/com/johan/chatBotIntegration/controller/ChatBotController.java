package com.johan.chatBotIntegration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.johan.chatBotIntegration.model.ChatBot;
import com.johan.chatBotIntegration.service.ChatBotService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/chatbots")
@Tag(name = "ChatBot Controller", description = "APIs for ChatBot Management")
public class ChatBotController {

    @Autowired
    private ChatBotService chatBotService;

    @PostMapping
    @Operation(summary = "Add new ChatBot")
    public ResponseEntity<?> addChatBot(@RequestBody ChatBot chatBot) {
        try {
            ChatBot savedChatBot = chatBotService.saveChatBot(chatBot);
            return new ResponseEntity<>(savedChatBot, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add ChatBot", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    @Operation(summary = "Get all ChatBots") 
    public ResponseEntity<?> getAllChatBots() {
        try {
            List<ChatBot> chatBots = chatBotService.getAllChatBots();
            return new ResponseEntity<>(chatBots, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch ChatBots", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/integration")
    @Operation(summary = "Get Integration Status")
    public ResponseEntity<?> getIntegrationStatus(@RequestParam String platform) {
        try {
            List<ChatBot> chatBots = chatBotService.getIntegrationStatus(platform);
            return new ResponseEntity<>(chatBots, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch integration status", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete ChatBot")
    public ResponseEntity<?> deleteChatBot(@PathVariable Long id) {
        try {
            chatBotService.deleteChatBot(id);
            return new ResponseEntity<>("ChatBot deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete ChatBot", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}