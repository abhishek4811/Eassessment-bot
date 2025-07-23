package com.eassessment.chatbot.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OllamaRequest {
	private String model;
	private List<Map<String,String>> messages;
	private boolean stream;
	
	public void addMessage(String role , String content) {
		Map<String,String> msg = new HashMap<String, String>();
		msg.put("role", role);
		msg.put("content", content);
		messages.add(msg);
		
	}

	public OllamaRequest() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
