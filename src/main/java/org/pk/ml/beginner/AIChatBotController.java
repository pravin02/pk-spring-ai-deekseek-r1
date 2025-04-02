package org.pk.ml.beginner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/ai")
public class AIChatBotController {

    Logger LOGGER = LoggerFactory.getLogger(AIChatBotController.class);
    @Autowired
    private ChatClient chatClient;

    @PostMapping("/chat")
    public Flux<String> askToAI(@RequestBody ChatRequest chatRequest) {
        LOGGER.info("askToAI: body: {}", chatRequest);
        return chatClient.prompt()
                .user(chatRequest.emailContent())
                .stream().content();
    }
}
