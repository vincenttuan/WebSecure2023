package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/add/cookie")
public class AddCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 設置 cookie
		Cookie cookie = new  Cookie("msg", "john");
		cookie.setMaxAge(60 * 60 * 24 * 365);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		resp.addCookie(cookie);
		resp.getWriter().print("add cookie ok");
	}
	
}
