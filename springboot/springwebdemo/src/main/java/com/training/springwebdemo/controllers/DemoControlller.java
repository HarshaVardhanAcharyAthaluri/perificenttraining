package com.training.springwebdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;

@Controller
public class DemoControlller {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Hello iam Model data");
		mav.setViewName("greet");
		return mav;
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	
}
