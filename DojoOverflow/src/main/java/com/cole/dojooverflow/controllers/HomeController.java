package com.cole.dojooverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cole.dojooverflow.models.Question;
import com.cole.dojooverflow.services.AnswerService;
import com.cole.dojooverflow.services.QuestionService;
import com.cole.dojooverflow.services.TagService;

@Controller
public class HomeController {
	@Autowired
	private QuestionService qService;
	@Autowired
	private AnswerService aService;
	@Autowired
	private TagService tService;
	
	@GetMapping("/")
	public String indexRedirect() {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {
		viewModel.addAttribute("allQuestions", this.qService.getAllQuestions());
		return "dashboard.jsp";
	}
	@GetMapping("/questions/new")
	public String newQ(@ModelAttribute("question")Question question) {
		return "question.jsp";
	}
	
}
