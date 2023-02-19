package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mango")
public class MangoController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/input")
	public String input(Model model, HttpServletRequest request, HttpServletResponse response) {
		String myName = request.getParameter("myName");
		System.out.println("myName: " + myName);
		
		List list  = null;
		String sql = "select myname, amount, cardNo, memo from Mango where myname='" + myName + "'";
		System.out.println("sql: " + sql);
		list = jdbcTemplate.queryForList(sql);
		
		model.addAttribute("myName", myName);
		model.addAttribute("list", list);
		return "mango/input";
	}
	
	@RequestMapping("/add")
	public String add(Model model, HttpServletRequest request, HttpServletResponse response) {
		String myName= request.getParameter("myName");
		String cardNo= request.getParameter("cardNo");
		String amount= request.getParameter("amount");
		String memo= request.getParameter("memo");
		
		String sql = "insert into Mango(myname, cardno, amount, memo) values(?, ?, ?, ?)";
		int rowcount =  jdbcTemplate.update(sql, myName, cardNo, amount, memo);
		System.out.println("rowcount: " + rowcount);
		
		// 有新增一筆資料
		if(rowcount == 1) {
			// 加入 cookie
			Cookie myNameCookie = new Cookie("myName", myName);
			Cookie cardNoCookie = new Cookie("cardNo", cardNo);
			// 將 cookie 傳給瀏覽器
			response.addCookie(myNameCookie);
			response.addCookie(cardNoCookie);
		}
		
		return "redirect:./input?myName=" + myName;
	}
	
}
