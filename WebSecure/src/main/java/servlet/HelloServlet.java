package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 取得 client 端的 Headers
		Enumeration<String> names = req.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.printf("%s: %s\n", name, req.getHeader(name));
		}
				 
		resp.getWriter().print("Secure: $1,500,000 Browser only");
	}
	
	
	
}
