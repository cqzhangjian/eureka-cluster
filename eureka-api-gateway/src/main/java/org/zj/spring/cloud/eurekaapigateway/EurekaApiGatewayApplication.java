package org.zj.spring.cloud.eurekaapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.zj.spring.cloud.eurekaapigateway.filter.AccessFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class EurekaApiGatewayApplication {

	@Bean
	public AccessFilter accessFilter () {
		return new AccessFilter();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaApiGatewayApplication.class, args);
	}
}
