package com.cole.dojooverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cole.dojooverflow.services.QuestionService;

@Controller
public class HomeController {
	@Autowired
	private QuestionService oService;
	
	@GetMapping("/")
	public String indexRedirect() {
		return "redirect:/dashboard";
	}
	
	public String dashboard(Model viewModel) {
		viewModel.addAttribute("allQuestions", this.oService.getAllQuestions());
		return "question.jsp";
	}
}
