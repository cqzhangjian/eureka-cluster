package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value ="user-service")
public interface UserServiceApi {

	@GetMapping("/user/hello")
	String getInfo();
}
