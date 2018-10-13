package org.zj.spring.cloud.eurekauserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaUserServiceApplication.class, args);
	}
}
