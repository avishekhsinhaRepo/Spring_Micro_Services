package com.springcloud.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApigatewayserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayserviceApplication.class, args);
	}

}
