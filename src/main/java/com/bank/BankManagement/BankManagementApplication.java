package com.bank.BankManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan("com.bank.BankManagement.Entity")
@EnableJpaRepositories("com.bank.BankManagement.Repository")
@EnableConfigurationProperties
public class BankManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankManagementApplication.class, args);
	}
		@Bean
		public RestTemplate getRestTemplate() {
			return new RestTemplate();
		}


}
