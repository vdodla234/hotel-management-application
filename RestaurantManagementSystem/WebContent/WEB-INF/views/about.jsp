<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h1 class="title_heading">${restName}</h1>
<h2>${restDesc}</h2>
<h1>Contact Information</h1>
<p>${contact}</p>
<p>${address}</p>
</body>
</html>