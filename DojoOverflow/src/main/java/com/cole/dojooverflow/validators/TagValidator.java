package com.cole.dojooverflow.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.cole.dojooverflow.models.Question;

@Component
public class TagValidator {
	public boolean supports(Class<?> clazz) {
		return Question.class.equals(clazz);
	}
	public void validate(Object target, Errors errors) {
		Question question = (Question) target;
		String[] tags = question.getTags().split(", ");
		if (tags.length>3) {
			errors.rejectValue("tagsFromFrontEnd", "too many tags", "Use 3 or fewer tags");
		}
	}
}
