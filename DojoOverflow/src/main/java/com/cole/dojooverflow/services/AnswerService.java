package com.cole.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cole.dojooverflow.models.Answer;
import com.cole.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository aRepo;
	
	public List<Answer> getAllAnswers(){
		return this.aRepo.findAll();
	}
}
