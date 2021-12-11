package com.cole.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cole.dojooverflow.models.Tag;
import com.cole.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	
	public List<Tag> getAllTags(){
		return this.tRepo.findAll();
	}
}
