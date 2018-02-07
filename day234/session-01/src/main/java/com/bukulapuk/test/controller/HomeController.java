package com.bukulapuk.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bukulapuk.test.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/home")
	//buat nyelipin data
	public String index(Model model) {
		
		model.addAttribute("users",userRepository.getUserByLimit(5,0));
		
		return "index";
	}
}
