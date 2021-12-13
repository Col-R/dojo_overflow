package com.cole.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cole.dojooverflow.models.Answer;
import com.cole.dojooverflow.models.Question;
import com.cole.dojooverflow.services.AnswerService;
import com.cole.dojooverflow.services.QuestionService;
import com.cole.dojooverflow.services.TagService;
import com.cole.dojooverflow.validators.TagValidator;

@Controller
public class HomeController {
	@Autowired
	private QuestionService qService;
	@Autowired
	private AnswerService aService;
	@Autowired
	private TagService tService;
	@Autowired
	private TagValidator validator;
	
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
	@PostMapping("/addQuestion")
	public String addQ(@Valid @ModelAttribute("question")Question question, BindingResult result) {
		validator.validate(question, result);
		if(result.hasErrors()) {
			return "question.jsp";
		}
		this.tService.createQuestion(question);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/question/{id}")
	public String show(Model viewModel, @ModelAttribute("answer")Answer answer, @PathVariable("id")Long id) {
		viewModel.addAttribute("question",this.qService.getOneQuestion(id));
		return "answer.jsp";
	}
}
