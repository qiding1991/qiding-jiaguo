package com.qiding.jiaguo.user.config;

import com.qiding.jiaguo.common.mail.JMailConfig;
import com.qiding.jiaguo.user.service.JMailService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.mail")
    public JMailConfig jMailConfig() {
        return new JMailConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = "mail.content")
    public JMailService jMailService() {
        return new JMailService();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }



}
