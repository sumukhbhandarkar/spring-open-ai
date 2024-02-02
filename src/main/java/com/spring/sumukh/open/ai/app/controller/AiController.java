package com.spring.sumukh.open.ai.app.controller;

import com.spring.sumukh.open.ai.app.dao.Completion;
import org.springframework.ai.client.AiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {
    private final AiClient aiClient;

    @Autowired
    public AiController(AiClient aiClient) {
        this.aiClient = aiClient;
    }

    @GetMapping("/ai")
    public Completion completion(@RequestParam(value = "message", defaultValue = "Tell me a joke!") String message) {
        return new Completion(aiClient.generate(message));
    }
}
