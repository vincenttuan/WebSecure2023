package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mango")
public class MangoController {
	
	public String input(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "mango/input";
	}
	
}
