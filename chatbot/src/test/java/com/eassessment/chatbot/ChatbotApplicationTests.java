package com.eassessment.chatbot;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.eassessment.util.SystemPromptLoader;

@SpringBootTest
class ChatbotApplicationTests {
	

	@MockBean
	private SystemPromptLoader systemPromptLoader;
	
	@Test
	void contextLoads() {
			when(systemPromptLoader.getPrompt()).thenReturn("dummy");
	}

}
