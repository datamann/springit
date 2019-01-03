package com.sbs.springit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.sbs.springit.config.SpringitProperties;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);
	
	@Autowired
	private SpringitProperties springitProperties;

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}
	
	@Bean
	@Profile("dev")
	CommandLineRunner runner() {
		return args -> {
			System.out.println("Welcome message: " + springitProperties.getWelcomeMsg());
			System.out.println("I would only do this in dev.");
			
			log.error("CommandLineRunner.run();");
			log.warn("CommandLineRunner.run();");
			log.info("CommandLineRunner.run();");
			log.debug("CommandLineRunner.run();");
			log.trace("CommandLineRunner.run();");
		};
	}
	
}

