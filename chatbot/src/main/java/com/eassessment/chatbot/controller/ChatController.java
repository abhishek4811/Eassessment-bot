package com.eassessment.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eassessment.chatbot.dto.ChatRequest;
import com.eassessment.chatbot.dto.ChatResponse;
import com.eassessment.chatbot.service.ChatService;

@RestController
@RequestMapping("/bot/chat")
public class ChatController {
	@Autowired
	private ChatService chatService;
	
	@PostMapping
	public String chat(@RequestBody ChatRequest request) {
		ChatResponse response = new ChatResponse(chatService.chat(request));
		return response.getReply() ;
		
	}
}
