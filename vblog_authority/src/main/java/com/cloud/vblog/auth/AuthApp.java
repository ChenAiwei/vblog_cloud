package com.cloud.vblog.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringCloudApplication
@EnableDiscoveryClient
public class AuthApp {
	public static void main(String[] args) {
		SpringApplication.run(AuthApp.class, args);
	}
}
