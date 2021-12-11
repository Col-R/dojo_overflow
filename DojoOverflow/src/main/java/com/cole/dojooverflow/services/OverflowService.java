package com.cole.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cole.dojooverflow.models.Question;
import com.cole.dojooverflow.repositories.QuestionRepository;

@Service
public class OverflowService {
	@Autowired
	private QuestionRepository qRepo;
//	TO DO:
//	@Autowired
//	private AnswerRepository aRepo;
//	@Autowired
//	private UserRepository uRepo;
	
	public List<Question> getAllQuestions(){
		return this.qRepo.findAll();
	}
}
