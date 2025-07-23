package com.eassessment.model;

import com.eassessment.chatbot.Enum.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Message {
	private Role role;
	private String content;
}
