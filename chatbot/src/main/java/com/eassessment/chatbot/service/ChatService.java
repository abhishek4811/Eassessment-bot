package com.eassessment.chatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eassessment.chatbot.dto.ChatRequest;
import com.eassessment.chatbot.dto.OllamaRequest;
import com.eassessment.util.SystemPromptLoader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {
	

	private final SystemPromptLoader systemPromptLoader;
	
	public String chat(ChatRequest request) {
		
		RestTemplate restTemplate = new RestTemplate();
		String prompts = systemPromptLoader.getPrompt();


		OllamaRequest ollamaRequest = new OllamaRequest();
		ollamaRequest.setModel("eassessment-bot");
		ollamaRequest.addMessage("system" , prompts);
		ollamaRequest.addMessage("role", request.getRole().toString());
		ollamaRequest.setStream(false);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<OllamaRequest> entity = new HttpEntity<>(ollamaRequest , headers);
		try {
			String response = restTemplate.postForObject("http://localhost:11434/api/chat", entity, String.class);
			System.out.println("response from ollama "+response);
			return response;
		}catch (Exception e) {
			System.out.println("error :"+e.getMessage());
			return e.getMessage();
		}
		
		
//		System.out.println("request message is "+ request.getMessage());
//		
//		ProcessBuilder builder = new ProcessBuilder("ollama","run","eassessment-bot");
//		System.out.println("ollama started");
//		
//		
//		StringBuilder output = new StringBuilder();
//		
//		
//		try {
//			Process process = builder.start();
//			
//			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
//			bufferedWriter.write(request.getMessage());
//			bufferedWriter.newLine();
//			bufferedWriter.flush();
//			bufferedWriter.close();
//			
//			System.out.println("message sent to ollama");
//			
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//			String line;
//			while((line = bufferedReader.readLine()) != null) {
//				System.out.println("entering the loop");
//				output.append(line).append("\n");
//			}
//			System.out.println("Response is "+ output.toString());
//			
//			
//			
//		}catch (Exception e) {
//			return "Error calling llm: "+e.getMessage();
//		}
//		return output.toString().trim();
		
	}

	
}
