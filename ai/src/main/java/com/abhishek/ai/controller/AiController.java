package com.abhishek.ai.controller;

import com.abhishek.ai.dto.AiRequest;
import com.abhishek.ai.dto.AiResponse;
import com.abhishek.ai.service.AiService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("questionRequest", new AiRequest());
        return "home";
    }

    @PostMapping("/ask")
    public String askQuestion(
            @Valid @ModelAttribute("questionRequest") AiRequest request,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "home";
        }

        AiResponse response = aiService.askQuestion(request);
        model.addAttribute("answerResponse", response);
        model.addAttribute("questionRequest", new AiRequest());

        return "home";
    }
}