package com.jindal.user.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MiscConfigurations {

    @Bean
    @LoadBalanced
    RestTemplate getRestTemmplate() {
		return new RestTemplate();
	}
}
