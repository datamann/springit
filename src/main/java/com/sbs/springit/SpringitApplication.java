package com.sbs.springit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.sbs.springit.config.SpringitProperties;
import com.sbs.springit.domain.Comment;
import com.sbs.springit.domain.Link;
import com.sbs.springit.repository.CommentsRepository;
import com.sbs.springit.repository.LinkRepository;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
@EnableJpaAuditing
public class SpringitApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);
	
	@Autowired
	private SpringitProperties springitProperties;

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}
	
	//@Bean
	@Profile("dev")
	CommandLineRunner runner(LinkRepository linkRepository, CommentsRepository commentsRepository) {
		return args -> {
			System.out.println("Welcome message: " + springitProperties.getWelcomeMsg());
			System.out.println("I would only do this in dev.");
			
			log.error("CommandLineRunner.run();");
			log.warn("CommandLineRunner.run();");
			log.info("CommandLineRunner.run();");
			log.debug("CommandLineRunner.run();");
			log.trace("CommandLineRunner.run();");
			
			//("Title 1", "https://vg.no");
			Link link = new Link("Getting started with Spring Boot 2", "https://vg.no");
			
			linkRepository.save(link);
			
			Comment comment = new Comment("This Spring Boot 2 link is awesome!", link);
			commentsRepository.save(comment);
			link.addComment(comment);
			
			Link firstTitle = linkRepository.findByTitle("Getting started with Spring Boot 2");
			System.out.println("Title found: " + firstTitle.getTitle());
			
			List<Link> allTitles = linkRepository.findByTitleLikeOrderByCreationDateDesc("Getting started with Spring Boot 2");			
			for (int i = 0; i < allTitles.size(); i++) {
				System.out.println(allTitles.get(i));
			}
			
			for (Link temp : allTitles) {
				System.out.println(temp.getTitle());
			}
		};
	}
	
}

