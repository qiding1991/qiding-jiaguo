package com.qiding.jiaguo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.jvm.hotspot.HelloWorld;

@SpringBootApplication
public class QidingJiaguoGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(QidingJiaguoGatewayApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@RestController
	public class Welcome{
		@RequestMapping("/")
		public String  welcome(){
			return "success";
		}
	}
}
