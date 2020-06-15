package com.wave.uis.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.wave.uis.model.entity.UserEntity;
import com.wave.uis.repository.UserIdentityRepository;

@EnableMongoRepositories(basePackageClasses = UserIdentityRepository.class)
@Configuration
public class MongoDBConfiguration {

	@Bean
	CommandLineRunner commandLineRunner(UserIdentityRepository userProfileRepo) {
		return strings -> {
			userProfileRepo.save(new UserEntity("test_id", "test_email", "test_password"));

		};
	}

}
