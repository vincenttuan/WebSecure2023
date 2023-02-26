<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//response.setHeader("Content-Security-Policy", "script-src 'self' 'unsafe-inline' ");
	response.setHeader("Content-Security-Policy", "script-src 'self' 'unsafe-inline' 'nonce-1234' ");

%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CSP Nonce</title>
	
	<script nonce="1234">
		alert('OK');
	</script>
	
	<script>
		alert('Hacker');
	</script>		
	
</head>
<body>
	<h1>CSP Nonce</h1>
	<form method="post" action="notebook.jsp">
		<textarea rows="5" cols="50" name="note">
			
		</textarea><p>
		<input type="submit">
	</form>
	<hr>
	${ param.note }
</body>
</html>