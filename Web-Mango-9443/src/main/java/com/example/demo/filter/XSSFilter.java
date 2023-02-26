package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.owasp.esapi.filters.SecurityWrapperRequest;

public class XSSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 將請求參數進行過濾，避免 XSS 攻擊
		SecurityWrapperRequest wrapperRequest = new SecurityWrapperRequest((HttpServletRequest) request);
		// 過濾後進行傳遞
		chain.doFilter(wrapperRequest, response);
		
	}

}
