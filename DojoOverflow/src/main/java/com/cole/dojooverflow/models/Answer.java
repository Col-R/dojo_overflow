package com.cole.dojooverflow.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answers")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
