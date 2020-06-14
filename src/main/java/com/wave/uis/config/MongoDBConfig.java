package com.wave.uis.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.wave.uis.model.entity.UserIdentity;
import com.wave.uis.repository.UserIdentityRepository;

@EnableMongoRepositories(basePackageClasses = UserIdentityRepository.class)
@Configuration
public class MongoDBConfig {

	@Bean
	CommandLineRunner commandLineRunner(UserIdentityRepository userProfileRepo) {
		return strings -> {
			userProfileRepo.save(new UserIdentity("fef", "sdfrgw", "wegwbbÏ"));

		};
	}

}
