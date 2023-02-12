package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/read/cookie")
public class ReadCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 讀取 cookie
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies) {
			resp.getWriter().print(cookie.getName() + ":" + cookie.getValue() + "\n");
		}
	}
}
