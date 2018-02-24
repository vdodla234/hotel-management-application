<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
	<div class="container-fluid">
	<h1 class="text-danger">${msg}</h1>
		<form class="form-horizontal" action="login" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">User Id:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userId" name="username"
						placeholder="Enter user id" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd" name="password"
						placeholder="Enter password" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="userType">Select
					your role</label>
				<div class="col-sm-10">
					<label class="radio-inline"><input type="radio"
						name="jobtype" value="Manager" required>Manager</label> <label class="radio-inline"><input
						type="radio" name="jobtype" value="Part time Employee">Part time Employee</label> <label
						class="radio-inline"><input type="radio" name="jobtype" value="Full time Employee">Full
						time Employee</label>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Submit</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>