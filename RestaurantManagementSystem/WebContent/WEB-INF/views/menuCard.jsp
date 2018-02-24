<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
	<div class="container-fluid">
	<h1 class="text-success">${msg}</h1>
	<table class="table table-striped text-centered">
		<thead>
		<tr>
			<th>Item Name</th>
			<th>Price</th>
			<c:choose><c:when test="${employee.jobtype eq 'Manager'}"><th>Action</th></c:when></c:choose>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${menus}" var="menu">
			<tr>
				<td>${menu.itemName} (${menu.description})</td>
				<td>${menu.cost}</td>
				<c:choose><c:when test="${employee.jobtype eq 'Manager'}"><td><form action="editmenucard" method="post">
				<input type="hidden" value="${menu.itemName}" name="itemName"/>
				<input type="submit" value="Edit" class="btn btn-default">
				</form>
				</td></c:when></c:choose>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>

</body>
</html>