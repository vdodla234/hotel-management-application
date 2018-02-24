<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row ">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 "></div>
		</div>
		<div class="row">
			<c:choose>
				<c:when test="${employee.jobtype eq 'Manager'}">
					<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
						<a href="${pageContext.request.contextPath}/editreservation">Edit
							Reservation</a>
					</div>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${employee.jobtype eq 'Manager'}">
					<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
						<a href="${pageContext.request.contextPath}/editmenu">Edit
							Menu</a>
					</div>
				</c:when>
			</c:choose>
			<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
				<a href="${pageContext.request.contextPath}/editpersonalinfo">Edit
					Personal information</a>
			</div>
		</div>
	</div>
</body>
</html>