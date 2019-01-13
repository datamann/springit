package com.sbs.springit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Comment extends Auditable{
	
	@Id
	@GeneratedValue
	private long id;
	
	@NonNull
	private String body;
	
	@ManyToOne
	@NonNull
	private Link link;
}
