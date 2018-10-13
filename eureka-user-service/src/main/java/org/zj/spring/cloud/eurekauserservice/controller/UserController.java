package org.zj.spring.cloud.eurekauserservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user/")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping(value="hello")
	public String sayHello(HttpServletRequest request) {
		logger.info("/hello,request-port:" + request.getRequestURL());
		return "Hello,EurekaClient";
	}

}
