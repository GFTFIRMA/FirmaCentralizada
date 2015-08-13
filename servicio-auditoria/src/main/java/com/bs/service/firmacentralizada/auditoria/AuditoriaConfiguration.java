package com.bs.service.firmacentralizada.auditoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class AuditoriaConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(AuditoriaConfiguration.class, args);
	}
}
