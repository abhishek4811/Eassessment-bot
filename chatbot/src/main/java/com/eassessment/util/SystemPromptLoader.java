package com.eassessment.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class SystemPromptLoader{
	
	@Value("classpath:modelfile")
	private Resource systemPromptResource;
	
	private String prompt;
	
	@PostConstruct
	public void init() {
		try {
			System.out.println("systempromptloader bean created");
			this.prompt = new String(systemPromptResource.getInputStream().readAllBytes() , StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("error while reading modelfiel : "+e.getMessage());
		}
	}
	
	public String getPrompt() {
		return prompt;
	}
}
