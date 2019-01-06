package com.sbs.springit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Comment {
	
	@Id
	@GeneratedValue
	private long id;
	private String body;
	
	@ManyToOne
	private Link link;
	
}
