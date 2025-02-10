package org.pk.ml.beginner;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AIChatBotController {

    @Autowired
    private ChatClient chatClient;

    @GetMapping("/ask")
    public Flux<String> askToAI(@RequestParam String question) {
        return chatClient.prompt()
                .user(question)
                .stream().content();
    }
}
