<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row ">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 "></div>
		</div>
		<div class="row">
			<form class="form-horizontal" action="reservation"
				method="post">

					<div class="col-xs-12 col-sm-1 col-md-1 col-lg-1 col-xl-1 "></div>
					<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 col-xl-8 ">
						<div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Guest
								name<span style="color: red; font-size: 15px">||</span>
							</label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="text" class="form-control" name="guestname" id="guestname"
									maxlength="20" placeholder="Enter your full name(firstname lastname)" pattern="[A-Za-z-0-9]+\s[A-Za-z-'0-9]+" value="${res.guestname}" required/><span
									id="a1" style="color: red;"></span>
							</div>
						</div>
						<div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Number of guests
								<span style="color: red; font-size: 15px">||</span>
							</label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="text" class="form-control" name="noofguests" id="noofguests"
									maxlength="3" placeholder="Enter number of guests" pattern="[0-9]" value="${res.noOfGuests}" required/><span
									id="a2" style="color: red;"></span>
							</div>
						</div>
						<div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Reservation type<span
								style="color: red; font-size: 15px">||</span></label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
							<select name="type" class="form-control" required>
							<option value="--select">--select--</option>
							<c:choose><c:when test="${res.reservationType eq 'Dinner'}"><option value="Dinner" selected>Dinner</option></c:when>
							<c:otherwise><option value="Dinner">Dinner</option></c:otherwise></c:choose>
							<c:choose><c:when test="${res.reservationType eq 'Breakfast'}"><option value="Breakfast" selected>Breakfast</option></c:when>
							<c:otherwise><option value="Breakfast">Breakfast</option></c:otherwise></c:choose>
							<c:choose><c:when test="${res.reservationType eq 'Brunch'}"><option value="Brunch" selected>Brunch</option></c:when>
							<c:otherwise><option value="Brunch">Brunch</option></c:otherwise></c:choose>
							<c:choose><c:when test="${res.reservationType eq 'lunch'}"><option value="Lunch" selected>Lunch</option></c:when>
							<c:otherwise><option value="Lunch">Lunch</option></c:otherwise></c:choose>
							</select>
							<span id="a3" style="color: red;"></span>
							</div>
						</div>
						<div class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6"></div>
						<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
							<input type="submit" value="submit"
								class="form-control  btn-success">
						</div>

					</div>
						
</form>
</div>
</div>
</body>
</html>