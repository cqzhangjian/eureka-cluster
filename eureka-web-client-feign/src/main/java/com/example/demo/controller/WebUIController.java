package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.UserServiceApi;

@RestController
@RequestMapping({"/index","/"})
public class WebUIController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserServiceApi userServiceApi;
	
	
	@GetMapping
	public ModelAndView index(Model model) {
		String info = userServiceApi.getInfo();
		model.addAttribute("msg", info);
		return new ModelAndView("views/index", "model", model);
	}
	
}
