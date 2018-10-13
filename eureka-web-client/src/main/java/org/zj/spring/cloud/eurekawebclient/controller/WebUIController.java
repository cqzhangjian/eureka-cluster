package org.zj.spring.cloud.eurekawebclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping({"/index","/"})
public class WebUIController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public ModelAndView index(Model model) {
		
		logger.info("web-client============================");
		
		String info = restTemplate.getForEntity("http://user-service/user/hello", String.class).getBody();
		
		logger.info("web-client============================"  + info);
		
		
		model.addAttribute("msg", info);
		return new ModelAndView("views/index", "model", model);
	}
	
}
