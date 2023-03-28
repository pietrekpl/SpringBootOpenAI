package com.example.springbootopenai.chatGpt.controller;

import com.example.springbootopenai.chatGpt.model.ChatGptResponse;
import com.example.springbootopenai.chatGpt.model.UserResponse;
import com.example.springbootopenai.chatGpt.service.BotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ChatGptController {
    private final BotService botService;

    @PostMapping("/send")
    public ChatGptResponse sendMessage(@RequestBody UserResponse userResponse) {
        return botService.askQuestion(userResponse);

    }
}
