<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>

function validateJobApplication(){
	 var a = document.getElementById("fullname").value;
     var c = document.getElementById("dob").value;
     var d = document.getElementById("education").value;
     var e = document.getElementById("experience").value;
     var f = document.getElementById("phoneNo").value;
     var g = document.getElementById("address").value;
     var h = document.getElementById("skills").value;
     
     if(a==null||a==""||a==" "){$("#a1").html("enter your name").show();}else{$("#a1").hide();}
     if(c==null||c==""||c==" "){$("#a2").html("enter date of birth").show();}else{$("#a2").hide();}
     if(d==null||d==""||d==" "){$("#a3").html("enter your degree qualification").show();}else{$("#a3").hide();}
     if(e==null||e==""||e==" "){$("#a4").html("enter experience").show();}else{$("#a4").hide();}
     if(f==null||f==""||f==" "){$("#a5").html("enter phone number").show();}else{$("#a5").hide();}
     if(g==null||g==""||g==" "){$("#a6").html("enter Address").show();}else{$("#a6").hide();}
     if(h==null||h==""||h==" "){$("#a7").html("select skills/achievements").show();}else{$("#a7").hide();}
     var radios = document.getElementsByName("jobtype");
     var formValid = false;
     var i = 0;
     while (!formValid && i < radios.length) {
         if (radios[i].checked) formValid = true;
         i++;        
     }
     if(!formValid){$("#a8").html("select skills/achievements").show();}else{$("#a8").hide();}
     if(a==null||a==""||a==" "||c==null||c==""||c==" "||d==null||d==""||d==" "||e==null||e==""||e==" "||f==null||f==""||f==" "||g==null||g==""||g==" "||h==null||h==""||h==" ")
     	{return false;}
     else
     	{return true;}	
}
</script>
<title>Job Application</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row ">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 "></div>
		</div>
		<div class="row">

			<form onsubmit="return validateJobApplication();"
				class="form-horizontal" action="application"
				method="post">

					<div class="col-xs-12 col-sm-1 col-md-1 col-lg-1 col-xl-1 "></div>
					<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 col-xl-8 ">
						<div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Full
								name<span style="color: red; font-size: 15px">||</span>
							</label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="text" class="form-control" name="fullname" id="fullname"
									maxlength="20" placeholder="Enter your full name" pattern="[A-Za-z-0-9]+\s[A-Za-z-'0-9]+" required value="${employee.fullname}"/><span
									id="a1" style="color: red;"></span>
							</div>
						</div>
						<div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Date
								of birth<span style="color: red; font-size: 15px">||</span>
							</label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="date" class="form-control datepicker" name="dob" id="dob"
									maxlength="10" placeholder="dd-mm-yyyy" value="${employee.dob}" required/><span id="a2"
									style="color: red;"></span>
							</div>
						</div>
						<div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Education<span
								style="color: red; font-size: 15px">||</span></label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="text" class="form-control" name="education" id="education"
									maxlength="20" placeholder="Enter your degree" value="${employee.education}" required/><span id="a3"
									style="color: red;"></span>
							</div>
						</div>
						<div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Experience
								in year<span style="color: red; font-size: 15px">||</span>
							</label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="text" class="form-control" name="experience" id="experience"
									maxlength="2" placeholder="Enter your experience in year" value="${employee.experience}" required /><span
									id="a4" style="color: red;"></span>
							</div>
						</div>
						<div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Phone
								number<span style="color: red; font-size: 15px">||</span>
							</label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="text" class="form-control" name="phoneNo" id="phoneNo"
									maxlength="10" placeholder="Enter your phone number" value="${employee.phoneNo}" required /><span
									id="a5" style="color: red;"></span>
							</div>
						</div>
						<div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Mail Id<span
								style="color: red; font-size: 15px">||</span></label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="text" class="form-control" name="address" id="address"
									maxlength="50" placeholder="Enter your Mail address" value="${employee.address}" required /><span
									id="a5" style="color: red;"></span>
							</div>
						</div>
						
							<div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Password<span
								style="color: red; font-size: 15px">||</span></label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="password" class="form-control" name="phoneNo" id="phoneNo"
									maxlength="10" placeholder="Enter your Password" value="${employee.password}" required /><span
									id="a5" style="color: red;"></span>
							</div>
						</div>
						
						
						<div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Skills/Achievements<span
								style="color: red; font-size: 15px">||</span></label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="text" class="form-control" name="skills" id="skills"
									maxlength="50" placeholder="Enter your skills" value="${employee.skills}" required/><span id="a7"
									style="color: red;"></span>
							</div>
						</div>
						<!-- <div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">User
								name<span style="color: red; font-size: 15px">||</span>
							</label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="text" class="form-control" name="username"
									maxlength="10" placeholder="Enter your user name" /><span
									id="a1" style="color: red;"></span>
							</div>
						</div> -->
						<!-- <div class="form-group">
							<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Password<span
								style="color: red; font-size: 15px">||</span></label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<input type="text" class="form-control" name="password"
									maxlength="50" placeholder="set your password" /><span
									id="a1" style="color: red;"></span>
							</div>
						</div> -->
						<div class="form-group">
						<label for=""
								class="col-xs-12 col-sm-5 col-md-5 col-lg-6 col-xl-6 control-label">Select your role<span
								style="color: red; font-size: 15px">||</span></label>
							<div class="col-xs-12 col-sm-7 col-md-6 col-lg-5 col-xl-5">
								<label class="radio-inline">
								<c:choose><c:when test="${employee.jobtype eq 'Manager' }">
								<input type="radio"	name="jobtype" value="Manager" required checked>Manager</c:when>
									<c:otherwise><input type="radio"
									name="jobtype" value="Manager" required>Manager</c:otherwise></c:choose></label> 
									<label class="radio-inline">
									<c:choose><c:when test="${employee.jobtype eq 'Part time Employee' }">
									<input type="radio" name="jobtype" value="Part time Employee" checked>Part time Employee</c:when>
									<c:otherwise><input type="radio" name="jobtype" value="Part time Employee">Part time Employee</c:otherwise></c:choose></label> <label
									class="radio-inline">
									<c:choose><c:when test="${employee.jobtype eq 'Full time Employee' }">
									<input type="radio" name="jobtype" value="Full time Employee" checked>Full
									time Employee</c:when>
									<c:otherwise><input type="radio" name="jobtype" value="Full time Employee">Full
									time Employee</c:otherwise> </c:choose></label><span
									id="a8" style="color: red;"></span>
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
<script>
$(function() {
    $( ".datepicker" ).datepicker({dateFormat: "dd-mm-yy"});
  });

</script>
</html>