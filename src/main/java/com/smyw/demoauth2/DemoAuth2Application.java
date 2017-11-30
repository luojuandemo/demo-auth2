package com.smyw.demoauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@ServletComponentScan
@EnableAuthorizationServer
public class DemoAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoAuth2Application.class, args);
	}
}
