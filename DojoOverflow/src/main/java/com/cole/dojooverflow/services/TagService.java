package com.cole.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cole.dojooverflow.models.Question;
import com.cole.dojooverflow.models.Tag;
import com.cole.dojooverflow.repositories.QuestionRepository;
import com.cole.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	@Autowired
	private QuestionRepository qRepo;
	
	public List<Tag> getAllTags(){
		return this.tRepo.findAll();
	}
	
	public Tag getOneTag(String subject) {
		return this.tRepo.findBySubject(subject);
	}
	
	public ArrayList<Tag> createTags(String tags) {
		ArrayList<Tag> tagsForQ = new ArrayList<Tag>();
		String[] tagsReceived = tags.split(", ");
		for(String s : tagsReceived) {
			if(this.tRepo.existsBySubject(s)) {
				Tag tagToAdd = this.getOneTag(s);
				tagsForQ.add(tagToAdd);
			} else {
				Tag newTag = new Tag();
				newTag.setSubject(s);
				this.tRepo.save(newTag);
				tagsForQ.add(this.getOneTag(s));
			}
		}
		
		return tagsForQ;
	}
	public Question createQuestion(Question question) {
		question.setQtags(this.createTags(question.getTags()));
		return this.qRepo.save(question);
	}
}
