<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
        
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   <style type="text/css">
.errStyle {
	color:red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<div class="container">
<%@ include file="/resources/header.jsp" %>
<title>Shopping chart</title>
</head>
<body style="background-color:gray">
<center><h1>Shopping Cart</h1>
</center>
 
<%@include file="/resources/navbar.jsp" %>
<form:form role="form" action="user/register" modelAttribute="userDetails">
<div class="form-group">
 	<form:label  path="userId">
				<spring:message text="Name"/>
	</form:label>
	<form:input class="form-control" path="userId" pattern=".{4,7}" required="true"
						title="id should contains 4 to 7 characters" />
		<form:errors path="userId" >
			<p class="errStyle">
					* Required
</p>
 </form:errors>
 </div>
  <div class="form-group">
 	<form:label  path="userName">
				<spring:message text="User Name"/>
	</form:label>
	<form:input class="form-control" path="userName" required="true"
						title="name should not be empty" />
		<form:errors path="userName" >
			<p class="errStyle">
					* Invalid Username
</p>
 </form:errors>
 </div>
 <div class="form-group">
 	<form:label  path="password">
				<spring:message text="Password"/>
	</form:label>
	<form:input type="password" class="form-control" path="password" pattern=".{4,15}"
						required="true"
						title="password should contains 4 to 15 characters" />
		<form:errors path="password" >
			<p class="errStyle">
					* Invalid Email
</p>
 </form:errors>
 
  </div>
  <div class="form-group">
 	<form:label  path="email">
				<spring:message text="Email"/>
	</form:label>
	<form:input class="form-control" path="email" />
		<form:errors path="email" >
			<p class="errStyle">
					* Invalid Email
</p>
 </form:errors>
 </div>
  <div class="form-group">
 	<form:label  path="mobile">
				<spring:message text="Phone Number"/>
	</form:label>
	<form:input class="form-control" path="mobile" pattern="^\d{5}$" required="true"
						title="Please enter valid mobile number" />
		<form:errors path="mobile" >
			<p class="errStyle">
					* Invalid Phone no.
</p>
 </form:errors>
 </div>

  <div class="form-group">
 	<form:label  path="address">
				<spring:message text="Address"/>
	</form:label>
	<form:input class="form-control" path="address" />
		<form:errors path="address" >
			<p class="errStyle">
					* Invalid Address
</p>
 </form:errors>
 </div> 
 
  <button type="submit" class="btn btn-default">Submit</button>
</form:form>

</div>

</body>
</html>