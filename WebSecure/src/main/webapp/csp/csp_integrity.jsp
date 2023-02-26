<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	response.setHeader("Content-Security-Policy", "script-src 'self' 'sha384-AyGSauO6j5wlKDXBGlPmlCFlP3T0P9b4gG7AhTGzegAjqGQnwMLm1g3MKGqIfOFO' ");
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CSP Integrity</title>
</head>
<body>
	<h1>
		<!--  在 HTML 中執行帶有 integrity 屬性的 Javascript -->
		<script src="hello.js" integrity="sha384-AyGSauO6j5wlKDXBGlPmlCFlP3T0P9b4gG7AhTGzegAjqGQnwMLm1g3MKGqIfOFO"></script>
	</h1>
	<form method="post" action="csp_nonce.jsp">
		<textarea rows="5" cols="50" name="note">
			
		</textarea><p>
		<input type="submit">
	</form>
	<hr>
	${ param.note }
</body>
</html>