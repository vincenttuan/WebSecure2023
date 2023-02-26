<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.UUID" %>
<%
	//response.setHeader("Content-Security-Policy", "script-src 'self' 'unsafe-inline' ");
	String cspNonce = UUID.randomUUID().toString().replaceAll("-", "");
	response.setHeader("Content-Security-Policy", "script-src 'self' 'unsafe-inline' 'nonce-"+cspNonce+"' ");
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CSP Nonce</title>
	
	<!--  在 HTML 中不帶有 nonce 屬性的 Javascript 不會被執行 -->
	<script>
		alert('Hacker');
	</script>		
	
</head>
<body>
	<h1>
		<!--  在 HTML 中執行帶有 nonce 屬性的 Javascript -->
		<script nonce="<%=cspNonce %>">
			document.write('CSP Nonce');
		</script>
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