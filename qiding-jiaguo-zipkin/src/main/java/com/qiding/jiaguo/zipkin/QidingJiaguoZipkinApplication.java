package com.qiding.jiaguo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

@EnableDiscoveryClient
@EnableZipkinServer
@SpringBootApplication
public class QidingJiaguoZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(QidingJiaguoZipkinApplication.class, args);
	}

}
