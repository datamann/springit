package com.sbs.springit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Vote {
	
	@Id
	@GeneratedValue
	private Long id;
	private int vote;
	
	// User
	// Link
	
}
