<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="common.jsp"></jsp:include>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Restaurant</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath}/">Home</a></li>
      <li> <a href="${pageContext.request.contextPath}/MenuController">Menu</a></li>
      <li><a href="${pageContext.request.contextPath}/reservation">Reservation</a></li>
      <li><a href="${pageContext.request.contextPath}/about">About Us</a></li>
      <li><a href="${pageContext.request.contextPath}/application">Job Application</a></li>
      <li><a href="${pageContext.request.contextPath}/login">Employee Login</a></li>
      <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
    </ul>
  </div>
</nav>

</body>
</html>