package com.cole.dojooverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cole.dojooverflow.services.QuestionService;

@Controller
public class HomeController {
	@Autowired
	private QuestionService qService;
	
	@GetMapping("/")
	public String indexRedirect() {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {
		viewModel.addAttribute("allQuestions", this.qService.getAllQuestions());
		return "question.jsp";
	}
}
