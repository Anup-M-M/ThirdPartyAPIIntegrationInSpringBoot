package com.example.ThirdPartyAPIIntegrationInSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ThirdPartyApiIntegrationInSpringBootApplication {

	// @Bean annotation create the Object of the RestTemplate and assigned it to the Application Context
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ThirdPartyApiIntegrationInSpringBootApplication.class, args);
	}

}
