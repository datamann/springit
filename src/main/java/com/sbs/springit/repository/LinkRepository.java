package com.sbs.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbs.springit.domain.Link;

public interface LinkRepository extends JpaRepository<Link, Long>{
	
	Link findByTitle(String title);

}
