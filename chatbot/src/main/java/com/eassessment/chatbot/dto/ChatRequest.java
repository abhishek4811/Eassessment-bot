package com.eassessment.chatbot.dto;

import com.eassessment.chatbot.Enum.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
public class ChatRequest {
	private Role role;
	private String message;
	
}
