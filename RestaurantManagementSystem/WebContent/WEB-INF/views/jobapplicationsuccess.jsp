<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Application</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="container-fluid">
<h1 class="text-success">
Your account has been successfully created.
Please use your email Id and password for login.
</h1>
<div class="alert alert-danger">
  <strong>${errorMessage}</strong>
</div>
</div>
</body>
</html>